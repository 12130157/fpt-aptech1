
import java.awt.*;
import java.io.*;
import com.java4less.rreport.*;


public class exampleExportReport  implements RAreaListener
{

  int total=0;
  public String exportFormat="";

 public static void main(String[] args) {
        exampleExportReport f=new exampleExportReport();

        f.exportFormat="DHTML";
        if (args.length>0) {
            if (args[0].toUpperCase().compareTo("-PDF")==0) f.exportFormat="PDF";
            if (args[0].toUpperCase().compareTo("-CSV")==0) f.exportFormat="CSV";
            if (args[0].toUpperCase().compareTo("-XML")==0) f.exportFormat="XML";
            if (args[0].toUpperCase().compareTo("-TXT")==0) f.exportFormat="TXT";
            }

	f.init();
 }

 // data arrays
public static String[] columnsNames = {"Article",
                        "Description","Priority",
                        "Quantity","Price"};

public static Object[][] columnsData = {
    {"A0301", "Printer XXX", "0",new Integer(300),new Double(30.9)},
    {"B0301", "CD-ROM writer","2", new Integer(200),new Double(3.0)},
    {"C0405", "Laptop SP","1", new Integer(330),new Double(4500.9)},
	{"D1001", "Mouse 45","0", new Integer(100),new Double(23.08)},
    {"E3044", "Keyboard Ms 250","0", new Integer(300),new Double(223.901)},
    {"F9902", "Mouse PS2","0", new Integer(1300),new Double(34)},
    {"G2387", "Laser printer LP300","0", new Integer(3200),new Double(56.09)},
	{"H0993", "Laser printer LP200","1", new Integer(200),new Double(3.93)}};

 public void init() {

                 // load report from file
		RReportImp report=new RReportImp(null);

                System.out.println("loading report");
		if (!report.importReport("order.rep")) System.out.println("Error, could not load file");


		report.getAreaByName("Detail").setListener(this);
		// set the values for the header programatically
		report.getReportHeader().getItemByName("Number").setruntimeValue("111");
		report.getReportHeader().getItemByName("Date").setruntimeValue("10/10/2000");
		report.getReportHeader().getItemByName("Company").setruntimeValue("COMPANY PLC");
		report.getReportHeader().getItemByName("City").setruntimeValue("London");
		report.getReportHeader().getItemByName("address").setruntimeValue("Street 2");

		// we use the Array as data source
		report.getAreaByName("Detail").setDataSource(new RArraySource(columnsNames,columnsData));

		// set listener to calculate amounts on the fly
		report.getReportFooter().setListener(this);

        if (this.exportFormat.equalsIgnoreCase("PDF")) exportPDF(report);
        else if  (this.exportFormat.equalsIgnoreCase("XML"))  exportXML(report);
        else if  (this.exportFormat.equalsIgnoreCase("CSV"))  exportCSV(report);
        else if  (this.exportFormat.equalsIgnoreCase("TXT"))  exportText(report);
        else exportDHTML(report);


        System.exit(0);
 }

 /**
  * export report to PDF format
  */
  private void exportPDF(RReport rep) {

                rep.setPDFFile("report.pdf"); // set pdf file
                rep.disablePrinting(true);
         	rep.prepare();
                System.out.println("finishing report");
		rep.endReport();
                System.out.println("File exported: REPORT.PDF");
 }

 /**
  * export report to DHTML format
  */
  private void exportDHTML(RReport rep) {


                rep.setHTMLActive(true);

                rep.disablePrinting(true);

         	rep.prepare();

                System.out.println("finishing report");

		rep.endReport();

                System.out.println("Writing to html file");

                // get dthml output
                String htmlString= rep.getHTML();

              try {

               java.io.OutputStreamWriter out2= new java.io.OutputStreamWriter(new java.io.FileOutputStream("report.html"),System.getProperty("file.encoding"));

		out2.write(htmlString,0,htmlString.length());
		out2.close();
		} catch (Exception e) {
                    e.printStackTrace();
                 }

              System.out.println("File exported: REPORT.HTML");

 }

  /**
  * export report to TXT format
  */
  private void exportText(RReport rep) {

  try {
          rep.disablePrinting(true);
          rep.setTextMode(true);
          rep.setTextModeColumns(80);
          rep.setTextModeRows(60);

          rep.prepare();
          System.out.println("finishing report");
	  rep.endReport();

          java.util.Vector pages=rep.exportTXT();
          java.io.FileOutputStream os=new java.io.FileOutputStream("Report.txt");

          for (int i=0;i<pages.size();i++) {
            StringBuffer[] page=(StringBuffer[]) pages.elementAt(i);

            for (int j=0;j<page.length;j++) {
                  os.write(page[j].toString().getBytes());
                  os.write(new String("\n").getBytes());
            }
          }

          os.close();

          System.out.println("File exported: REPORT.TXT");

      }
      catch (Exception e) {e.printStackTrace();}
  }


 /**
  * export report to CSV format
  */
 private void exportCSV(RReport rep) {

  try {
          CsvLayer layer= new CsvLayer();

          rep.disablePrinting(true);
          rep.prepare();
          System.out.println("finishing report");
          rep.endReport();
          rep.export(layer);

          java.io.FileOutputStream os=new java.io.FileOutputStream("Report.csv");

           os.write(layer.getOutput().getBytes());

          os.close();

          System.out.println("File exported: REPORT.csv");

      }
      catch (Exception e) {e.printStackTrace();}
  }



 /**
  * export report to XML format
  */
private void exportXML(RReport rep) {

    try {

      XmlLayer layer= new XmlLayer(rep.getPageWidthPixels(),rep.getPageHeightPixels(),rep.getTitle());
      layer.nestAreas=true;
      rep.disablePrinting(true);
      rep.prepare();
      System.out.println("finishing report");
      rep.endReport();
      rep.export(layer);
      System.out.println("File exported: REPORT.XML");

      String xmlString= layer.getOutput();
      java.io.OutputStreamWriter out2= new java.io.OutputStreamWriter(new java.io.FileOutputStream("report.xml"),System.getProperty("file.encoding"));
      out2.write(xmlString,0,xmlString.length());
      out2.close();

      }
      catch (Exception e) {e.printStackTrace();}

  }

 public void beforePrintingArea(RArea area) {

   // calculate the amount	of each line
	 if (area.getName().compareTo("Detail")==0) {
		 double price=((Double) area.getItemByName("Price").getruntimeValue()).doubleValue();
		 int quantity=((Integer) area.getItemByName("Quantity").getruntimeValue()).intValue();
		 total=(int) (total+(quantity*price));
		 area.getItemByName("Amount").setruntimeValue(new Integer((int) (quantity*price)));
	 }

   // set total amount
	 if (area.getName().compareTo("Footer")==0) {
		 area.getItemByName("Total").setruntimeValue(new Integer(total));
		 total=0;
	 }

 }



}