import java.awt.*;
import com.java4less.rreport.*;


public class exampleOrder extends Frame implements RAreaListener
{

  int total=0;

 public static void main(String[] args) {
        exampleOrder f=new exampleOrder();
		f.setVisible(true);
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
		RReportImp report=new RReportImp(this);

		if (!report.importReport("order.rep")) System.exit(0);

                // this will skip the printer dialog!
                RPrintSetupJDK13 pt=new RPrintSetupJDK13();
                pt.showDialog=false;
                report.setPrintSetup(pt);

		// set the images for the combo box. This can only be done programatically
		java.awt.Image[] comboImages=new Image[3];
		comboImages[0]=new RImageFile("ball1.gif").getImage();
		comboImages[1]=new RImageFile("ball2.gif").getImage();
		comboImages[2]=new RImageFile("ball3.gif").getImage();
		((RCombo) report.getAreaByName("Detail").getItemByName("Priority")).Values=comboImages;


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


		// create preview window
		RReportWindow Win= new RReportWindow(report,this);

		// this will print the Header Area and all dependent areas (the detail area)
		report.prepare();

		report.endReport();
		Win.show();

		System.exit(0);

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
