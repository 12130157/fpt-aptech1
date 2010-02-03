// This application contains 3 reports.
// - Function createReport1(). Creates a report containing all kind of ROjbects
//              This report can use 6 different function to show how to feed data:
//				- Example1(): program driven printing
//				- Example2(): array as data source
//				- Example3(): JTable as data source
//				- Example4(): JDBC
//				- Example5(): printing a JTable
//				- Example6(): printing without preview
// - Function createReport2(). Creates a report with background images and filled areas
// - Function createReport3(). Creates a report containing a chart
//

import com.java4less.rreport.*;
import com.java4less.rchart.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class app extends java.awt.Frame implements java.awt.event.ActionListener
{

// data arrays for report 1
public static String[] columnsNames = {"TextArticle",
                        "TextDescription",
                        "TextQuantity","TextPrice"};

public static Object[][] columnsData = {
    {"A0301", "Printer XXX", "300",new Double(30.9)},
    {"B0301", "CD-ROM writer", "200",new Double(3.0)},
    {"C0405", "Laptop SP", "330",new Double(4500.9)},
	{"D1001", "Mouse 45", "100",new Double(23.08)},
    {"E3044", "Keyboard Ms 250", "300",new Double(223.901)},
    {"F9902", "Mouse PS2", "1300",new Double(34)},
    {"G2387", "Laser printer LP300", "3200",new Double(56.09)},
	{"H0993", "Laser printer LP200", "200",new Double(3.93)}};

// data arrays for report 2
static java.awt.Image  Image2=new RImageFile("ball2.gif").getImage();
static java.awt.Image Image1=new RImageFile("ball1.gif").getImage();
static java.awt.Image   Image3=new RImageFile("ball3.gif").getImage();

public static String[] columnsNames2 = {"TextArticle",
                        "TextDescription","ComboPriority",
                        "TextQuantity","TextPrice"};

public static Object[][] columnsData2 = {
    {"A0301", "Printer XXX",Image1, "300",new Double(30.9)},
    {"B0301", "CD-ROM writer",Image1, "200",new Double(3.0)},
    {"C0405", "Laptop SP",Image2, "330",new Double(4500.9)},
	{"D1001", "Mouse 45",Image1, "100",new Double(23.08)},
    {"E3044", "Keyboard Ms 250",Image3, "300",new Double(223.901)},
    {"F9902", "Mouse PS2",Image1, "1300",new Double(34)},
    {"G2387", "Laser printer LP300",Image2, "3200",new Double(56.09)},
	{"H0993", "Laser printer LP200",Image2, "200",new Double(3.93)}};



  public static RReportWindow Win;
  public static RReport rep;
  public static RArea HDR_PurchaseOrder;
  public static RArea DETAIL_PurchaseOrder;
  public static RArea PFOOTER_PurchaseOrder;
  public static app MainWin=new app();

  // components of the main window
  Button btnExit= new Button("Exit");
  List list =new List(2,false);
  Label msg=new Label("Please select an example by double clicking: ");


  public app() {
    super("Main window of example application");
	this.setLayout(null);
	this.setSize(300,130);

	msg.setBounds(8,20,220,30);

	// available examples
    list.setBounds(8,53,220,60);
    list.add("1. Example from MSAccess");
    list.add("2. Filling and background");
    list.add("3. Charts and tables");
	list.addActionListener(this);

	btnExit.setBounds(235,53,50,30);
    btnExit.setActionCommand("EXIT");
    btnExit.addActionListener(this);

	this.add(msg);
    this.add(list);
    this.add(btnExit);

    this.show();
  }


  public void actionPerformed(java.awt.event.ActionEvent a) {

     String c=a.getActionCommand();
     if (c.compareTo("EXIT")==0) {System.exit(0);}

     // run selected example
     if (c.substring(0,2).compareTo("1.")==0)  {createReport1();}
     if (c.substring(0,2).compareTo("2.")==0)  {createReport2();}
     if (c.substring(0,2).compareTo("3.")==0)  {createReport3();}


     this.paintAll(this.getGraphics());

  }

//
// Main program
//
public static void main(String[] args) {

}


//
// report 1
//

private static void createReport1() {


rep=new RReport((Frame) MainWin,28);

// LABELS AND FIELDS OF THE HEADER

HDR_PurchaseOrder= new RArea();
HDR_PurchaseOrder.width=16.429;
HDR_PurchaseOrder.height=4.074;
RField lbltitle=new RField();
lbltitle.name="lbltitle";
lbltitle.setConstant(true);
lbltitle.x=0.132;
lbltitle.y=0.079;
lbltitle.width=7.339;
lbltitle.height=0.82;
lbltitle.setdefaultValue("Purchase Order");
lbltitle.Align=RField.ALIGN_LEFT;
lbltitle.FontColor=java.awt.Color.red;
lbltitle.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,18);
HDR_PurchaseOrder.add(lbltitle);

RField TextCompanyName=new RField();
TextCompanyName.name="TextCompanyName";
TextCompanyName.setConstant(false);
TextCompanyName.x=9.762;
TextCompanyName.y=1.587;
TextCompanyName.width=6.28;
TextCompanyName.height=0.423;
TextCompanyName.Align=RField.ALIGN_LEFT;
TextCompanyName.Expand=false;
TextCompanyName.Compress=false;
TextCompanyName.FontColor=java.awt.Color.black;
TextCompanyName.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
HDR_PurchaseOrder.add(TextCompanyName);

RField TextAddress=new RField();
TextAddress.name="TextAddress";
TextAddress.setConstant(false);
TextAddress.x=9.762;
TextAddress.y=2.222;
TextAddress.width=6.254;
TextAddress.height=0.423;
TextAddress.Align=RField.ALIGN_LEFT;
TextAddress.Expand=false;
TextAddress.Compress=false;
TextAddress.FontColor=java.awt.Color.black;
TextAddress.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
HDR_PurchaseOrder.add(TextAddress);

RField TextCity=new RField();
TextCity.name="TextCity";
TextCity.setConstant(false);
TextCity.x=9.762;
TextCity.y=2.857;
TextCity.width=6.228;
TextCity.height=0.423;
TextCity.Align=RField.ALIGN_LEFT;
TextCity.Expand=false;
TextCity.Compress=false;
TextCity.FontColor=java.awt.Color.black;
TextCity.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
HDR_PurchaseOrder.add(TextCity);

RField TextNumber=new RField();
TextNumber.name="TextNumber";
TextNumber.setConstant(false);
TextNumber.x=2.169;
TextNumber.y=1.587;
TextNumber.width=2.974;
TextNumber.height=0.45;
TextNumber.Align=RField.ALIGN_LEFT;
TextNumber.Expand=false;
TextNumber.Compress=false;
TextNumber.FontColor=java.awt.Color.black;
TextNumber.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
HDR_PurchaseOrder.add(TextNumber);

RField lbNumber=new RField();
lbNumber.name="lbNumber";
lbNumber.setConstant(true);
lbNumber.x=0.026;
lbNumber.y=1.587;
lbNumber.width=1.931;
lbNumber.height=0.397;
lbNumber.setdefaultValue("Number");
lbNumber.Align=RField.ALIGN_LEFT;
lbNumber.FontColor=java.awt.Color.black;
lbNumber.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,12);
HDR_PurchaseOrder.add(lbNumber);

RField TextDate=new RField();
TextDate.name="TextDate";
TextDate.setConstant(false);
TextDate.x=2.169;
TextDate.y=2.222;
TextDate.width=2.974;
TextDate.height=0.45;
TextDate.Align=RField.ALIGN_LEFT;
TextDate.Expand=false;
TextDate.Compress=false;
TextDate.FontColor=java.awt.Color.black;
TextDate.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
HDR_PurchaseOrder.add(TextDate);

RField lblDate=new RField();
lblDate.name="lblDate";
lblDate.setConstant(true);
lblDate.x=0.026;
lblDate.y=2.222;
lblDate.width=1.931;
lblDate.height=0.397;
lblDate.setdefaultValue("Date");
lblDate.Align=RField.ALIGN_LEFT;
lblDate.FontColor=java.awt.Color.black;
lblDate.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,12);
HDR_PurchaseOrder.add(lblDate);

String[] K_ComboPriority={"0","1"};
String[] V_ComboPriority={"Normal","Urgent"};
RCombo ComboPriority=new RCombo(K_ComboPriority,V_ComboPriority);
ComboPriority.name="ComboPriority";
ComboPriority.x=2.169;
ComboPriority.y=2.857;
ComboPriority.width=3;
ComboPriority.height=0.423;
ComboPriority.FontColor=java.awt.Color.black;
ComboPriority.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
HDR_PurchaseOrder.add(ComboPriority);

RField lblPriority=new RField();
lblPriority.name="lblPriority";
lblPriority.setConstant(true);
lblPriority.x=0;
lblPriority.y=2.857;
lblPriority.width=1.931;
lblPriority.height=0.397;
lblPriority.setdefaultValue("Priority");
lblPriority.Align=RField.ALIGN_LEFT;
lblPriority.FontColor=java.awt.Color.black;
lblPriority.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,12);
HDR_PurchaseOrder.add(lblPriority);

RCheck ChkApproved=new RCheck();
ChkApproved.name="ChkApproved";
ChkApproved.x=2.937;
ChkApproved.y=3.36;
ChkApproved.width=0.459;
ChkApproved.height=0.423;
HDR_PurchaseOrder.add(ChkApproved);

RField lblApproved=new RField();
lblApproved.name="lblApproved";
lblApproved.setConstant(true);
lblApproved.x=0.026;
lblApproved.y=3.36;
lblApproved.width=2.54;
lblApproved.height=0.397;
lblApproved.setdefaultValue("Approved");
lblApproved.Align=RField.ALIGN_LEFT;
lblApproved.FontColor=java.awt.Color.black;
lblApproved.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,12);
HDR_PurchaseOrder.add(lblApproved);

RPicture Logo=new RPicture();
Logo.name="Logo";
Logo.setConstant(true);
Logo.x=12.831;
Logo.y=0.106;
Logo.width=3.254;
Logo.height=1.296;
Logo.ImageHTMLAddress="logo.gif";
java.awt.Image im_Logo=new RImageFile("logo.gif").getImage();
Logo.setdefaultValue(im_Logo);


HDR_PurchaseOrder.add(Logo);


rep.setReportHeader(HDR_PurchaseOrder);

// COLUMNS HEADERS OF THE LINES

RArea PHDR_PurchaseOrder= new RArea();
PHDR_PurchaseOrder.width=16.429;
PHDR_PurchaseOrder.height=0.714;
RRectangle Rect1=new RRectangle();
Rect1.x=0;
Rect1.y=0;
Rect1.width=16.376;
Rect1.height=0.714;
Rect1.color=java.awt.Color.black;
PHDR_PurchaseOrder.add(Rect1);

RField lblArticle=new RField();
lblArticle.name="lblArticle";
lblArticle.setConstant(true);
lblArticle.x=0.106;
lblArticle.y=0;
lblArticle.width=2.561;
lblArticle.height=0.503;
lblArticle.setdefaultValue("Article");
lblArticle.Align=RField.ALIGN_LEFT;
lblArticle.FontColor=java.awt.Color.black;
lblArticle.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,12);
PHDR_PurchaseOrder.add(lblArticle);

RField lblDescription=new RField();
lblDescription.name="lblDescription";
lblDescription.setConstant(true);
lblDescription.x=2.91;
lblDescription.y=0;
lblDescription.width=5.196;
lblDescription.height=0.503;
lblDescription.setdefaultValue("Description");
lblDescription.Align=RField.ALIGN_LEFT;
lblDescription.FontColor=java.awt.Color.black;
lblDescription.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,12);
PHDR_PurchaseOrder.add(lblDescription);

RField lblQuantity=new RField();
lblQuantity.name="lblQuantity";
lblQuantity.setConstant(true);
lblQuantity.x=9.921;
lblQuantity.y=0;
lblQuantity.width=2.196;
lblQuantity.height=0.503;
lblQuantity.setdefaultValue("Quantity");
lblQuantity.Align=RField.ALIGN_LEFT;
lblQuantity.FontColor=java.awt.Color.black;
lblQuantity.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,12);
PHDR_PurchaseOrder.add(lblQuantity);

RField lblPrice=new RField();
lblPrice.name="lblPrice";
lblPrice.setConstant(true);
lblPrice.x=13.254;
lblPrice.y=0;
lblPrice.width=2.196;
lblPrice.height=0.503;
lblPrice.setdefaultValue("Price");
lblPrice.Align=RField.ALIGN_LEFT;
lblPrice.FontColor=java.awt.Color.black;
lblPrice.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,12);
PHDR_PurchaseOrder.add(lblPrice);

// REPORT FOOTER, page number

rep.setPageHeader(PHDR_PurchaseOrder);

PFOOTER_PurchaseOrder= new RArea();
PFOOTER_PurchaseOrder.width=16.429;
PFOOTER_PurchaseOrder.height=0.767;
RField TextPageNUmber=new RField();
TextPageNUmber.name="TextPageNUmber";
TextPageNUmber.setConstant(false);
TextPageNUmber.x=0.238;
TextPageNUmber.y=0.185;
TextPageNUmber.width=3;
TextPageNUmber.height=0.423;
TextPageNUmber.Align=RField.ALIGN_LEFT;
TextPageNUmber.Expand=false;
TextPageNUmber.Compress=false;
TextPageNUmber.FontColor=java.awt.Color.black;
TextPageNUmber.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,10);
PFOOTER_PurchaseOrder.add(TextPageNUmber);


rep.setPageFooter(PFOOTER_PurchaseOrder);

// LINES

DETAIL_PurchaseOrder= new RArea();
DETAIL_PurchaseOrder.width=16.429;
DETAIL_PurchaseOrder.height=0.7;
RField TextArticle=new RField();
TextArticle.name="TextArticle";
TextArticle.setConstant(false);
TextArticle.x=0.03;
TextArticle.y=0;
TextArticle.width=3;
TextArticle.height=0.423;
TextArticle.Align=RField.ALIGN_LEFT;
TextArticle.Expand=false;
TextArticle.Compress=false;
TextArticle.FontColor=java.awt.Color.black;
TextArticle.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
DETAIL_PurchaseOrder.add(TextArticle);

RField TextDescription=new RField();
TextDescription.name="TextDescription";
TextDescription.setConstant(false);
TextDescription.x=3.042;
TextDescription.y=0;
TextDescription.width=6.915;
TextDescription.height=0.423;
TextDescription.Align=RField.ALIGN_LEFT;
TextDescription.Expand=false;
TextDescription.Compress=false;
TextDescription.FontColor=java.awt.Color.black;
TextDescription.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
DETAIL_PurchaseOrder.add(TextDescription);

RField TextQuantity=new RField();
TextQuantity.name="TextQuantity";
TextQuantity.setConstant(false);
TextQuantity.x=9.921;
TextQuantity.y=0;
TextQuantity.width=3.132;
TextQuantity.height=0.423;
TextQuantity.Align=RField.ALIGN_RIGHT;
TextQuantity.Expand=false;
TextQuantity.Compress=false;
TextQuantity.FontColor=java.awt.Color.black;
TextQuantity.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
DETAIL_PurchaseOrder.add(TextQuantity);

RField TextPrice=new RField();
TextPrice.name="TextPrice";
TextPrice.setConstant(false);
TextPrice.x=13.042;
TextPrice.y=0;
TextPrice.width=3.265;
TextPrice.height=0.423;
TextPrice.Align=RField.ALIGN_RIGHT;
TextPrice.Expand=false;
TextPrice.Compress=false;
TextPrice.FontColor=java.awt.Color.black;
TextPrice.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
DETAIL_PurchaseOrder.add(TextPrice);


HDR_PurchaseOrder.marginBottom=0.5;

// format of the date and the price
TextDate.format="dd/MM/yyyy";
TextPrice.format="######.00";
TextPageNUmber.setdefaultValue("[Page] / [Pages]");

rep.setPageFrameStyle(new RLineStyle(0.2f,java.awt.Color.gray,RLineStyle.LINE_NORMAL));

rep.setTitle("Example");
rep.setHTMLActive(true);

setHeaderValues();

Example1();

//Example2();

//Example3();

//Example4();  // to run this example you need to create an ODBC entry for the RReport.mdb file
			   // and load the appropiate jdbc driver manager (see code in Example4())

//Example5();

//Example6();


}


private static void createReport2() {

rep=new RReport(MainWin);

// REPORT HEADER

HDR_PurchaseOrder= new RArea();
HDR_PurchaseOrder.width=16.429;
HDR_PurchaseOrder.height=4.074;
RField lbltitle=new RField();
lbltitle.name="lbltitle";
lbltitle.setConstant(true);
lbltitle.x=0.132;
lbltitle.y=0.079;
lbltitle.width=7.339;
lbltitle.height=0.82;
lbltitle.setdefaultValue("Purchase Order");
lbltitle.Align=RField.ALIGN_LEFT;
lbltitle.FontColor=java.awt.Color.red;
lbltitle.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,18);
HDR_PurchaseOrder.add(lbltitle);

RField TextCompanyName=new RField();
TextCompanyName.name="TextCompanyName";
TextCompanyName.setConstant(false);
TextCompanyName.x=9.762;
TextCompanyName.y=1.587;
TextCompanyName.width=6.28;
TextCompanyName.height=0.423;
TextCompanyName.Align=RField.ALIGN_LEFT;
TextCompanyName.Expand=false;
TextCompanyName.Compress=false;
TextCompanyName.FontColor=java.awt.Color.black;
TextCompanyName.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,14);
HDR_PurchaseOrder.add(TextCompanyName);

RField TextAddress=new RField();
TextAddress.name="TextAddress";
TextAddress.setConstant(false);
TextAddress.x=9.762;
TextAddress.y=2.222;
TextAddress.width=6.254;
TextAddress.height=0.423;
TextAddress.Align=RField.ALIGN_LEFT;
TextAddress.Expand=false;
TextAddress.Compress=false;
TextAddress.FontColor=java.awt.Color.black;
TextAddress.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,14);
HDR_PurchaseOrder.add(TextAddress);

RField TextCity=new RField();
TextCity.name="TextCity";
TextCity.setConstant(false);
TextCity.x=9.762;
TextCity.y=2.857;
TextCity.width=6.228;
TextCity.height=0.423;
TextCity.Align=RField.ALIGN_LEFT;
TextCity.Expand=true;
TextCity.Compress=false;
TextCity.FontColor=java.awt.Color.black;
TextCity.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,14);
HDR_PurchaseOrder.add(TextCity);

RField TextNumber=new RField();
TextNumber.name="TextNumber";
TextNumber.setConstant(false);
TextNumber.x=2.169;
TextNumber.y=1.587;
TextNumber.width=2.974;
TextNumber.height=0.45;
TextNumber.Align=RField.ALIGN_LEFT;
TextNumber.Expand=false;
TextNumber.Compress=false;
TextNumber.FontColor=java.awt.Color.black;
TextNumber.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,14);
HDR_PurchaseOrder.add(TextNumber);

RField lbNumber=new RField();
lbNumber.name="lbNumber";
lbNumber.setConstant(true);
lbNumber.x=0.026;
lbNumber.y=1.587;
lbNumber.width=1.931;
lbNumber.height=0.397;
lbNumber.setdefaultValue("Number");
lbNumber.Align=RField.ALIGN_LEFT;
lbNumber.FontColor=java.awt.Color.black;
lbNumber.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,14);
HDR_PurchaseOrder.add(lbNumber);

RField TextDate=new RField();
TextDate.name="TextDate";
TextDate.setConstant(false);
TextDate.x=2.169;
TextDate.y=2.222;
TextDate.width=2.974;
TextDate.height=0.45;
TextDate.Align=RField.ALIGN_LEFT;
TextDate.Expand=false;
TextDate.Compress=false;
TextDate.FontColor=java.awt.Color.black;
TextDate.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,14);
HDR_PurchaseOrder.add(TextDate);

RField lblDate=new RField();
lblDate.name="lblDate";
lblDate.setConstant(true);
lblDate.x=0.026;
lblDate.y=2.222;
lblDate.width=1.931;
lblDate.height=0.397;
lblDate.setdefaultValue("Date");
lblDate.Align=RField.ALIGN_LEFT;
lblDate.FontColor=java.awt.Color.black;
lblDate.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,14);
HDR_PurchaseOrder.add(lblDate);

java.awt.Image im_Logo1=new RImageFile("print.gif").getImage();
java.awt.Image im_Logo2=new RImageFile("exit.gif").getImage();



String[] K_ComboPriority={"0","1"};
Object[] V_ComboPriority={im_Logo1,im_Logo2};
RCombo ComboPriority=new RCombo(K_ComboPriority,V_ComboPriority);
ComboPriority.name="ComboPriority";
ComboPriority.x=2.169;
ComboPriority.y=2.857;
ComboPriority.width=3;
ComboPriority.height=0.423;
ComboPriority.FontColor=java.awt.Color.black;
ComboPriority.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,14);
HDR_PurchaseOrder.add(ComboPriority);

RField lblPriority=new RField();
lblPriority.name="lblPriority";
lblPriority.setConstant(true);
lblPriority.x=0;
lblPriority.y=2.857;
lblPriority.width=1.931;
lblPriority.height=0.397;
lblPriority.setdefaultValue("Priority");
lblPriority.Align=RField.ALIGN_LEFT;
lblPriority.FontColor=java.awt.Color.black;
lblPriority.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,14);
HDR_PurchaseOrder.add(lblPriority);

RCheck ChkApproved=new RCheck();
ChkApproved.name="ChkApproved";
ChkApproved.x=2.937;
ChkApproved.y=3.36;
ChkApproved.width=0.459;
ChkApproved.height=0.423;
HDR_PurchaseOrder.add(ChkApproved);

RField lblApproved=new RField();
lblApproved.name="lblApproved";
lblApproved.setConstant(true);
lblApproved.x=0.026;
lblApproved.y=3.36;
lblApproved.width=2.54;
lblApproved.height=0.397;
lblApproved.setdefaultValue("Approved");
lblApproved.Align=RField.ALIGN_LEFT;
lblApproved.FontColor=java.awt.Color.black;
lblApproved.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,14);
HDR_PurchaseOrder.add(lblApproved);

RPicture Logo=new RPicture();
Logo.name="Logo";
Logo.setConstant(true);
Logo.x=12.831;
Logo.y=0.106;
Logo.width=3.254;
Logo.height=1.296;
Logo.ImageHTMLAddress="logo.gif";


java.awt.Image im_Logo=new RImageFile("logo.gif").getImage();
Logo.setdefaultValue(im_Logo);


HDR_PurchaseOrder.add(Logo);

// background image
RPicture backPic=new RPicture();
backPic.name="Duplicate";
backPic.setConstant(true);
backPic.x=5.831;
backPic.y=8.106;
backPic.width=3.254;
backPic.height=1.296;
backPic.ImageHTMLAddress="";


java.awt.Image backImage=new RImageFile("duplicate.gif").getImage();

backPic.setdefaultValue(backImage);
rep.setPageBackgroundImage(backPic);


rep.setReportHeader(HDR_PurchaseOrder);

// COLUMN HEADERS OF THE LINES
RArea PHDR_PurchaseOrder= new RArea();
PHDR_PurchaseOrder.width=17;
PHDR_PurchaseOrder.height=0.714;

RField lblArticle=new RField();
lblArticle.name="lblArticle";
lblArticle.setConstant(true);
lblArticle.x=0.106;
lblArticle.y=0;
lblArticle.width=2.561;
lblArticle.height=0.503;
lblArticle.setdefaultValue("Article");
lblArticle.Align=RField.ALIGN_LEFT;
lblArticle.FontColor=java.awt.Color.black;
lblArticle.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,14);
PHDR_PurchaseOrder.add(lblArticle);

RField lblDescription=new RField();
lblDescription.name="lblDescription";
lblDescription.setConstant(true);
lblDescription.x=2.91;
lblDescription.y=0;
lblDescription.width=4.196;
lblDescription.height=0.503;
lblDescription.setdefaultValue("Description");
lblDescription.Align=RField.ALIGN_LEFT;
lblDescription.FontColor=java.awt.Color.black;
lblDescription.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,14);
PHDR_PurchaseOrder.add(lblDescription);

RField lblPrio=new RField();
lblPrio.name="lblPriority";
lblPrio.setConstant(true);
lblPrio.x=7.821;
lblPrio.y=0;
lblPrio.width=2.196;
lblPrio.height=0.503;
lblPrio.setdefaultValue("Priority");
lblPrio.Align=RField.ALIGN_LEFT;
lblPrio.FontColor=java.awt.Color.black;
lblPrio.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,14);
PHDR_PurchaseOrder.add(lblPrio);

RField lblQuantity=new RField();
lblQuantity.name="lblQuantity";
lblQuantity.setConstant(true);
lblQuantity.x=9.921;
lblQuantity.y=0;
lblQuantity.width=2.196;
lblQuantity.height=0.503;
lblQuantity.setdefaultValue("Quantity");
lblQuantity.Align=RField.ALIGN_LEFT;
lblQuantity.FontColor=java.awt.Color.black;
lblQuantity.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,14);
PHDR_PurchaseOrder.add(lblQuantity);

RField lblPrice=new RField();
lblPrice.name="lblPrice";
lblPrice.setConstant(true);
lblPrice.x=13.254;
lblPrice.y=0;
lblPrice.width=2.196;
lblPrice.height=0.503;
lblPrice.setdefaultValue("Price");
lblPrice.Align=RField.ALIGN_LEFT;
lblPrice.FontColor=java.awt.Color.black;
lblPrice.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,14);
PHDR_PurchaseOrder.add(lblPrice);


rep.setPageHeader(PHDR_PurchaseOrder);

PFOOTER_PurchaseOrder= new RArea();
PFOOTER_PurchaseOrder.width=17;
PFOOTER_PurchaseOrder.height=0.767;
RField TextPageNUmber=new RField();
TextPageNUmber.name="TextPageNUmber";
TextPageNUmber.setConstant(false);
TextPageNUmber.x=0.238;
TextPageNUmber.y=0.185;
TextPageNUmber.width=3;
TextPageNUmber.height=0.423;
TextPageNUmber.Align=RField.ALIGN_LEFT;
TextPageNUmber.Expand=false;
TextPageNUmber.Compress=false;
TextPageNUmber.FontColor=java.awt.Color.black;
TextPageNUmber.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,8);
PFOOTER_PurchaseOrder.add(TextPageNUmber);


rep.setPageFooter(PFOOTER_PurchaseOrder);

// LINES

DETAIL_PurchaseOrder= new RArea();
DETAIL_PurchaseOrder.width=17;
DETAIL_PurchaseOrder.height=0.703;
RField TextArticle=new RField();
TextArticle.name="TextArticle";
TextArticle.setConstant(false);
TextArticle.x=0.03;
TextArticle.y=0;
TextArticle.width=3;
TextArticle.height=0.423;
TextArticle.Align=RField.ALIGN_LEFT;
TextArticle.Expand=false;
TextArticle.Compress=false;
TextArticle.FontColor=java.awt.Color.black;
TextArticle.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,14);
DETAIL_PurchaseOrder.add(TextArticle);

RField TextDescription=new RField();
TextDescription.name="TextDescription";
TextDescription.setConstant(false);
TextDescription.x=3.042;
TextDescription.y=0;
TextDescription.width=6.915;
TextDescription.height=0.423;
TextDescription.Align=RField.ALIGN_LEFT;
TextDescription.Expand=false;
TextDescription.Compress=false;
TextDescription.FontColor=java.awt.Color.black;
TextDescription.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,14);
DETAIL_PurchaseOrder.add(TextDescription);

RPicture Prio=new RPicture();
Prio.name="txtPriority";
Prio.setConstant(false);
Prio.x=7.8;
Prio.y=0.106;
Prio.width=1.5;
Prio.height=0.423;
DETAIL_PurchaseOrder.add(Prio);

RField TextQuantity=new RField();
TextQuantity.name="TextQuantity";
TextQuantity.setConstant(false);
TextQuantity.x=9.921;
TextQuantity.y=0;
TextQuantity.width=3.132;
TextQuantity.height=0.423;
TextQuantity.Align=RField.ALIGN_RIGHT;
TextQuantity.Expand=false;
TextQuantity.Compress=false;
TextQuantity.FontColor=java.awt.Color.black;
TextQuantity.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,14);
DETAIL_PurchaseOrder.add(TextQuantity);

RField TextPrice=new RField();
TextPrice.name="TextPrice";
TextPrice.setConstant(false);
TextPrice.x=13.042;
TextPrice.y=0;
TextPrice.width=3.265;
TextPrice.height=0.423;
TextPrice.Align=RField.ALIGN_RIGHT;
TextPrice.Expand=false;
TextPrice.Compress=false;
TextPrice.FontColor=java.awt.Color.black;
TextPrice.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,14);
DETAIL_PurchaseOrder.add(TextPrice);

HDR_PurchaseOrder.marginBottom=0.5;
TextDate.format="dd/MM/yyyy";
TextPrice.format="######.00";
TextPageNUmber.setdefaultValue("[Page] / [Pages]");

// SUMMARY AREA (total amount)

RArea SUM_PurchaseOrder= new RArea();
SUM_PurchaseOrder.width=16.429;
SUM_PurchaseOrder.height=4.074;
RField lblSum=new RField();
lblSum.name="lbltitle";
lblSum.x=11;
lblSum.y=0.5;
lblSum.width=3.265;
lblSum.height=0.423;
lblSum.setdefaultValue("Total amount");
lblSum.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,14);
SUM_PurchaseOrder.add(lblSum);

RField TextSum=new RField();
TextSum.name="TextTotalAmount";
TextSum.x=13.042;
TextSum.y=0.5;
TextSum.width=3.265;
TextSum.height=0.423;
TextSum.Align=RField.ALIGN_RIGHT;
TextSum.format="######.00";
TextSum.Expand=false;
TextSum.Compress=false;
TextSum.FontColor=java.awt.Color.black;
TextSum.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,14);
SUM_PurchaseOrder.add(TextSum);

rep.setReportFooter(SUM_PurchaseOrder);


rep.setTitle("Example");
rep.setHTMLActive(true);

setHeaderValues();

// set frame for the detail area
PHDR_PurchaseOrder.setBackground(java.awt.Color.lightGray); // fill columns  headers
DETAIL_PurchaseOrder.setFrameType(RArea.FRAME_PAGE);
DETAIL_PurchaseOrder.setFrameStyle(new RLineStyle(0.2f,java.awt.Color.black,RLineStyle.LINE_NORMAL));

PHDR_PurchaseOrder.setFrameType(RArea.FRAME_AREA);
PHDR_PurchaseOrder.setFrameStyle(new RLineStyle(0.2f,java.awt.Color.black,RLineStyle.LINE_NORMAL));

rep.addArea(DETAIL_PurchaseOrder);

// load images (dots) used for the "priority" column

try{
java.awt.MediaTracker mt_Logo1 = new java.awt.MediaTracker(rep);
mt_Logo1.addImage(Image1,0); mt_Logo1.waitForID(0);
int Width_Im = Image1.getWidth(null);
}
catch(Exception ie_Logo1){};
try{
java.awt.MediaTracker mt_Logo2 = new java.awt.MediaTracker(rep);
mt_Logo2.addImage(Image2,0); mt_Logo2.waitForID(0);
int Width_Im = Image2.getWidth(null);
}
catch(Exception ie_Logo2){};
try{
java.awt.MediaTracker mt_Logo3 = new java.awt.MediaTracker(rep);
mt_Logo3.addImage(Image3,0); mt_Logo3.waitForID(0);
int Width_Im = Image3.getWidth(null);
}
catch(Exception ie_Logo3){};

// create preview window
Win= new RReportWindow(rep,MainWin);

DETAIL_PurchaseOrder.setDataSource(new RArraySource(columnsNames2,columnsData2));

rep.prepare();

//print here
rep.printArea(DETAIL_PurchaseOrder);

// set sumary value
Double sum=new Double(0);
for (int j=0;j<columnsData2[0].length;j++) {
	sum=new Double(sum.doubleValue()+((Double) columnsData2[j][4]).doubleValue());
}

TextSum.setruntimeValue(sum);

rep.endReport();
Win.show();

}



private static void createReport3() {

// Create Chart
// Download RChart demo for a description of these the charting classes

// data
double[] d1={1,2,3,4,5,4};
BarDataSerie data1= new BarDataSerie(d1,new FillStyle(java.awt.Color.orange));
data1.borderType=BarDataSerie.BORDER_RAISED;
data1.valueFont=new Font("Arial",Font.BOLD,10);

double[] d2={2,3,4,4.2,6.4,4.5};
BarDataSerie data2= new BarDataSerie(d2,new FillStyle(java.awt.Color.green));
data2.valueFont=new Font("Arial",Font.BOLD,10);
data2.borderType=BarDataSerie.BORDER_RAISED;
data2.negativeStyle=new FillStyle(java.awt.Color.red);


Legend l=new Legend();
l.border=new LineStyle(0.2f,java.awt.Color.black,LineStyle.LINE_NORMAL);
l.addItem("Company A",new FillStyle(java.awt.Color.orange));
l.addItem("Company B",new FillStyle(java.awt.Color.green));
l.background=new FillStyle(java.awt.Color.lightGray);

// create title
Title title=new Title("Benefits companies A & B");
// create axis
Axis  XAxis=new Axis(Axis.HORIZONTAL,new Scale());
Axis  YAxis=new Axis(Axis.VERTICAL,new Scale());
XAxis.tickAtBase=true; // draw also first tick
XAxis.scale.min=0;
XAxis.scale.max=6;
YAxis.scale.min=0;
YAxis.scale.max=7;
YAxis.IntegerScale=true;
YAxis.scaleTickInterval=1;
XAxis.scaleTickInterval=1;
XAxis.gridStyle=new LineStyle(0.2f,java.awt.Color.white,LineStyle.LINE_DOTS);
YAxis.gridStyle=new LineStyle(0.2f,java.awt.Color.white,LineStyle.LINE_DOTS);
String[] lbls={"1992","1993","1994","1995","1996","1997","1998","1999"};
XAxis.tickLabels=lbls;

HAxisLabel XLabel= new HAxisLabel("Year",java.awt.Color.black,new Font("Arial",Font.BOLD,12));
VAxisLabel YLabel= new VAxisLabel("million $",java.awt.Color.black,new Font("Arial",Font.BOLD,12));

// plotter
BarPlotter plot=new BarPlotter();
// create report
Chart chart=new Chart(title,plot,XAxis,YAxis);
plot.interBarSpace=1;
chart.XLabel=XLabel;
chart.YLabel=YLabel;
chart.legend=l;
chart.addSerie(data2);
chart.addSerie(data1);
chart.back=new FillStyle(java.awt.Color.white);

chart.setSize(450,400);
Image chartImage=MainWin.createImage(450,400);

// draw chart in image
chart.paint(chartImage.getGraphics());


// the report will be made of the chart image and a table for the values

rep=new RReport(MainWin);

RArea HDR= new RArea();
HDR.width=16.429;
HDR.height=4.074;

RPicture chartPic=new RPicture();
chartPic.name="Chart";
chartPic.setConstant(true);
chartPic.x=3;
chartPic.y=1;
chartPic.width=10;
chartPic.height=10;
chartPic.setdefaultValue(chartImage);
HDR.add(chartPic);

// data for the charts

// columns header
RArea CHDR= new RArea();
CHDR.width=14;
CHDR.height=0.7;
CHDR.marginLeft=1;
CHDR.verticalTab=5;
CHDR.horizontalTab=1;
CHDR.setFrameType(CHDR.FRAME_PAGE);

RField lblYear1= new RField();
lblYear1.name="Year1";
lblYear1.setConstant(true);
lblYear1.x=3;
lblYear1.y=0;
lblYear1.width=1.5;
lblYear1.height=0.503;
lblYear1.setdefaultValue("1993");
lblYear1.Align=RField.ALIGN_CENTER;
lblYear1.FontColor=java.awt.Color.black;
lblYear1.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,12);
CHDR.add(lblYear1);

RField lblYear2= new RField();
lblYear2.name="Year2";
lblYear2.setConstant(true);
lblYear2.x=4.5;
lblYear2.y=0;
lblYear2.width=1.5;
lblYear2.height=0.503;
lblYear2.setdefaultValue("1994");
lblYear2.Align=RField.ALIGN_CENTER;
lblYear2.FontColor=java.awt.Color.black;
lblYear2.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,12);
CHDR.add(lblYear2);


RField lblYear3= new RField();
lblYear3.name="Year3";
lblYear3.setConstant(true);
lblYear3.x=6;
lblYear3.y=0;
lblYear3.width=1.5;
lblYear3.height=0.503;
lblYear3.setdefaultValue("1995");
lblYear3.Align=RField.ALIGN_CENTER;
lblYear3.FontColor=java.awt.Color.black;
lblYear3.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,12);
CHDR.add(lblYear3);

RField lblYear4= new RField();
lblYear4.name="Year4";
lblYear4.setConstant(true);
lblYear4.x=7.5;
lblYear4.y=0;
lblYear4.width=1.5;
lblYear4.height=0.503;
lblYear4.setdefaultValue("1996");
lblYear4.Align=RField.ALIGN_CENTER;
lblYear4.FontColor=java.awt.Color.black;
lblYear4.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,12);
CHDR.add(lblYear4);

RField lblYear5= new RField();
lblYear5.name="Year5";
lblYear5.setConstant(true);
lblYear5.x=9;
lblYear5.y=0;
lblYear5.width=1.5;
lblYear5.height=0.503;
lblYear5.setdefaultValue("1997");
lblYear5.Align=RField.ALIGN_CENTER;
lblYear5.FontColor=java.awt.Color.black;
lblYear5.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,12);
CHDR.add(lblYear5);

RField lblYear6= new RField();
lblYear6.name="Year6";
lblYear6.setConstant(true);
lblYear6.x=10.5;
lblYear6.y=0;
lblYear6.width=1.5;
lblYear6.height=0.503;
lblYear6.setdefaultValue("1998");
lblYear6.Align=RField.ALIGN_CENTER;
lblYear6.FontColor=java.awt.Color.black;
lblYear6.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,12);
CHDR.add(lblYear6);
rep.addArea(CHDR);


// data
RArea LHDR= new RArea();
LHDR.width=14;
LHDR.height=0.7;
LHDR.marginLeft=1;
LHDR.setFrameType(LHDR.FRAME_PAGE);
LHDR.horizontalTab=1;


RField txtCompany= new RField();
txtCompany.name="txtCompany";
txtCompany.x=0;
txtCompany.y=0;
txtCompany.width=2.7;
txtCompany.height=0.503;
txtCompany.Align=RField.ALIGN_LEFT;
txtCompany.FontColor=java.awt.Color.black;
txtCompany.FontType=new java.awt.Font("Arial",java.awt.Font.BOLD,12);
LHDR.add(txtCompany);


RField txtYear1= new RField();
txtYear1.name="txtYear1";
txtYear1.x=3;
txtYear1.y=0;
txtYear1.width=1.5;
txtYear1.height=0.503;
txtYear1.Align=RField.ALIGN_CENTER;
txtYear1.FontColor=java.awt.Color.black;
txtYear1.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
LHDR.add(txtYear1);

RField txtYear2= new RField();
txtYear2.name="txtYear2";
txtYear2.x=4.5;
txtYear2.y=0;
txtYear2.width=1.5;
txtYear2.height=0.503;
txtYear2.Align=RField.ALIGN_CENTER;
txtYear2.FontColor=java.awt.Color.black;
txtYear2.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
LHDR.add(txtYear2);

RField txtYear3= new RField();
txtYear3.name="txtYear3";
txtYear3.x=6;
txtYear3.y=0;
txtYear3.width=1.5;
txtYear3.height=0.503;
txtYear3.Align=RField.ALIGN_CENTER;
txtYear3.FontColor=java.awt.Color.black;
txtYear3.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
LHDR.add(txtYear3);

RField txtYear4= new RField();
txtYear4.name="txtYear4";
txtYear4.x=7.5;
txtYear4.y=0;
txtYear4.width=1.5;
txtYear4.height=0.503;
txtYear4.Align=RField.ALIGN_CENTER;
txtYear4.FontColor=java.awt.Color.black;
txtYear4.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
LHDR.add(txtYear4);

RField txtYear5= new RField();
txtYear5.name="txtYear5";
txtYear5.x=9;
txtYear5.y=0;
txtYear5.width=1.5;
txtYear5.height=0.503;
txtYear5.Align=RField.ALIGN_CENTER;
txtYear5.FontColor=java.awt.Color.black;
txtYear5.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
LHDR.add(txtYear5);

RField txtYear6= new RField();
txtYear6.name="txtYear6";
txtYear6.x=10.5;
txtYear6.y=0;
txtYear6.width=1.5;
txtYear6.height=0.503;
txtYear6.Align=RField.ALIGN_CENTER;
txtYear6.FontColor=java.awt.Color.black;
txtYear6.FontType=new java.awt.Font("Arial",java.awt.Font.PLAIN,12);
LHDR.add(txtYear6);

String[] columnsNames3 = {"txtCompany","txtYear1","txtYear2","txtYear3","txtYear4","txtYear5","txtYear6"};

Object[][] columnsData3 = {
    {"Company A",  new Double(1.0),new Double(2.0),new Double(3.0),new Double(4.0),new Double(5.0),new Double(4.0)},
    {"Company B", new Double(2.0),new Double(3.0),new Double(4.0),new Double(4.2),new Double(6.4),new Double(4.5)}};

// set grid for the table
double[] cols={3,4.5,6,7.5,9,10.5}; // position where vertical lines must be displayed
LHDR.setGrid(cols);
LHDR.setGridStyle(new RLineStyle(0.2f,java.awt.Color.black,RLineStyle.LINE_DOTS));
LHDR.setFrameType(LHDR.FRAME_PAGE);
LHDR.setFrameStyle(new RLineStyle(0.2f,java.awt.Color.black,RLineStyle.LINE_NORMAL));
LHDR.setHorizontalGrid(true);
CHDR.setFrameType(CHDR.FRAME_AREA);
CHDR.setFrameStyle(new RLineStyle(0.2f,java.awt.Color.black,RLineStyle.LINE_NORMAL));

rep.addArea(LHDR);

LHDR.setDataSource(new RArraySource(columnsNames3,columnsData3));

Win= new RReportWindow(rep,MainWin);

rep.setReportHeader(HDR);

rep.setTitle("Example");
rep.setHTMLActive(false);

rep.prepare();
rep.printArea(CHDR);
rep.printArea(LHDR);
rep.endReport();

Win.show();


}

private static void setHeaderValues() {

HDR_PurchaseOrder.getItemByName("TextNumber").setruntimeValue("A200");
java.util.Calendar c =java.util.Calendar.getInstance();
HDR_PurchaseOrder.getItemByName("TextDate").setruntimeValue(c.getTime());
HDR_PurchaseOrder.getItemByName("TextCompanyName").setruntimeValue("Company Plc");
HDR_PurchaseOrder.getItemByName("TextAddress").setruntimeValue("ElmFIeld road 3");
HDR_PurchaseOrder.getItemByName("TextCity").setruntimeValue("London");
HDR_PurchaseOrder.getItemByName("ChkApproved").setruntimeValue(new Boolean(true));
HDR_PurchaseOrder.getItemByName("ComboPriority").setruntimeValue("1");

}

private static void Example1() {

	// example: program driven printing



  Win= new RReportWindow(rep,(java.awt.Frame) MainWin);

  rep.prepare();

  // line 1
  DETAIL_PurchaseOrder.getItemByName("TextArticle").setruntimeValue("A110");
  DETAIL_PurchaseOrder.getItemByName("TextDescription").setruntimeValue("Article1");
  DETAIL_PurchaseOrder.getItemByName("TextQuantity").setruntimeValue(new Integer(399));
  DETAIL_PurchaseOrder.getItemByName("TextPrice").setruntimeValue(new Double(43.9));
  rep.printArea(DETAIL_PurchaseOrder);

  // line 2
  DETAIL_PurchaseOrder.getItemByName("TextArticle").setruntimeValue("A112");
  DETAIL_PurchaseOrder.getItemByName("TextDescription").setruntimeValue("Article2");
  DETAIL_PurchaseOrder.getItemByName("TextQuantity").setruntimeValue(new Integer(299));
  DETAIL_PurchaseOrder.getItemByName("TextPrice").setruntimeValue(new Double(31.9));
  rep.printArea(DETAIL_PurchaseOrder);

  // line 3
  DETAIL_PurchaseOrder.getItemByName("TextArticle").setruntimeValue("A113");
  DETAIL_PurchaseOrder.getItemByName("TextDescription").setruntimeValue("Article3");
  DETAIL_PurchaseOrder.getItemByName("TextQuantity").setruntimeValue(new Integer(330));
  DETAIL_PurchaseOrder.getItemByName("TextPrice").setruntimeValue(new Double(46));
  rep.printArea(DETAIL_PurchaseOrder);

 rep.endReport();

 Win.show();

}

private static void Example2() {

// example: array as data source
Win= new RReportWindow(rep,MainWin);



DETAIL_PurchaseOrder.setDataSource(new RArraySource(columnsNames,columnsData));

rep.prepare();

//print here
rep.printArea(DETAIL_PurchaseOrder);

rep.endReport();
 Win.show();

}

private static void Example3() {

	// example: JTable as data source

Win= new RReportWindow(rep,MainWin);



javax.swing.JTable dataTable = new javax.swing.JTable(columnsData, columnsNames);
DETAIL_PurchaseOrder.setDataSource(new RJTableSource(dataTable.getModel()));

rep.prepare();

//print here
rep.printArea(DETAIL_PurchaseOrder);

rep.endReport();
 Win.show();

}

private static void Example4() {

	// example: JDBC
String errDesc="";

 Win= new RReportWindow(rep,MainWin);



 Connection con=null;
 Statement sta1=null;
 Statement sta2=null;

 try {
	// Load here the appropiate driver
    //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // for sun's jre, delphi...
     Class.forName("com.ms.jdbc.odbc.JdbcOdbcDriver"); // for MS J++

    con=DriverManager.getConnection("jdbc:odbc:RReport","","");
    sta1=con.createStatement();
    sta2=con.createStatement();
 } catch (Exception e) {
	 errDesc=e.getMessage();
  }

DETAIL_PurchaseOrder.setDataSource(new RJDBCSource(sta2,"Select * from PurchaseOrderLines"));
HDR_PurchaseOrder.setDataSource(new RJDBCSource(sta1,"Select * from PurchaseOrder"));

rep.prepare();

//print here
rep.printArea(DETAIL_PurchaseOrder);

rep.endReport();
 Win.show();

}

private static void Example5() {

	// example: printing a JTable

Win= new RReportWindow(rep,MainWin);


javax.swing.JTable dataTable = new javax.swing.JTable(columnsData, columnsNames);

RJTable RT=new RJTable(dataTable,0,0,18,0.75,0.75);
RT.createAreas();
rep.addArea(RT.getHeaderArea());
rep.addArea(RT.getDetailArea());

rep.setPageHeader(null);

rep.prepare();

//print here
rep.printArea(RT.getHeaderArea());
rep.printArea(RT.getDetailArea());

rep.endReport();
Win.show();
}

private static void Example6() {

// printing without preview

DETAIL_PurchaseOrder.setDataSource(new RArraySource(columnsNames,columnsData));

rep.prepare();

//print here
rep.printArea(DETAIL_PurchaseOrder);

rep.endReport();

System.exit(0);

}


}
