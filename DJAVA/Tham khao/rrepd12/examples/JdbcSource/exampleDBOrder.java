import java.awt.*;
import com.java4less.rreport.*;


public class exampleDBOrder extends Frame implements RAreaListener
{
	
  int total=0;	
 	
 public static void main(String[] args) {
        exampleDBOrder f=new exampleDBOrder();
		f.setVisible(true);
		f.init();	
 }
 
 public void init() {
	 
 // load report from file
		RReportImp report=new RReportImp(this);
					   
		if (!report.importReport("DBorder.rep")) System.exit(0);
		
		// set the images for the combo box. This can only be done programatically
		java.awt.Image[] comboImages=new Image[3];
		comboImages[0]=new RImageFile("ball1.gif").getImage();
		comboImages[1]=new RImageFile("ball2.gif").getImage();
		comboImages[2]=new RImageFile("ball3.gif").getImage();
		((RCombo) report.getAreaByName("Detail").getItemByName("Priority")).Values=comboImages;
		
		// set listener to calculate amounts on the fly
		report.getAreaByName("Detail").setListener(this);
		report.getReportFooter().setListener(this);
		
		
		// create preview window	  
		RReportWindow Win= new RReportWindow(report,this);

		// this will print the Header Area and all dependent areas
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
