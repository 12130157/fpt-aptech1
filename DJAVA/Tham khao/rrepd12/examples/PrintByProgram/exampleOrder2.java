import java.awt.*;
import com.java4less.rreport.*;


public class exampleOrder2 extends Frame 
{
	
  int total=0;	
 	
 public static void main(String[] args) {
        exampleOrder2 f=new exampleOrder2();
		f.setVisible(true);
		f.init();	
 }
 

 public void init() {
	 
 // load report from file
		RReportImp report=new RReportImp(this);
					   
		if (!report.importReport("order.rep")) System.exit(0);
		
		// set the values for the header programatically
		report.getReportHeader().getItemByName("Number").setruntimeValue("111");
		report.getReportHeader().getItemByName("Date").setruntimeValue("10/10/2000");
		report.getReportHeader().getItemByName("Company").setruntimeValue("COMPANY PLC");
		report.getReportHeader().getItemByName("City").setruntimeValue("London");
		report.getReportHeader().getItemByName("address").setruntimeValue("Street 2");
		
		// remove the link between Header and detail, we will trigger the printing programatically
		report.getAreaByName("Detail").setLinkedArea(null);
		
		RArea detail=report.getAreaByName("Detail");	
		
		// create preview window	  
		RReportWindow Win= new RReportWindow(report,this);

		// this will print the Header Area 
		report.prepare();
		
		// no print line 1
		detail.getItemByName("Article").setruntimeValue("FT455");
		detail.getItemByName("Description").setruntimeValue("Printer XXX");
		detail.getItemByName("Price").setruntimeValue(new Double(34.3));
		detail.getItemByName("Quantity").setruntimeValue("100");
		detail.getItemByName("Priority").setruntimeValue("0");
		detail.getItemByName("Amount").setruntimeValue("3430");
		report.printArea(detail);
		
		// no print line 2
		detail.getItemByName("Article").setruntimeValue("B301");
		detail.getItemByName("Description").setruntimeValue("CD-ROM writer");
		detail.getItemByName("Price").setruntimeValue(new Double(333.3));
		detail.getItemByName("Quantity").setruntimeValue("190");
		detail.getItemByName("Amount").setruntimeValue("63327");
		detail.getItemByName("Priority").setruntimeValue("1");
		report.printArea(detail);		
		
		
		// set total
		report.getReportFooter().getItemByName("Total").setruntimeValue(new Integer(66757));
		
		report.endReport();
		Win.show();	
		
		System.exit(0);
 
 }
 
 
 }
	
	

