INTRODUCTION

The product you downloaded contains:

- RReport Visual Builder (com.java4less.rreportVB) is a Java/Swing application to design report.
- RReport is 100% Java library (com.java4less.rreport) to print reports.

In order to run RReport Visual Designer you must.

- execute RUNSUN.BAT


--------------------------------------------------------------------------------------

DOCUMENTATION

- RReport Documentation: RReport_Help.html
- RReport Visual Builder documentation: RReportVB_Help.html
- RReport Java API: javadoc subdirectory.

--------------------------------------------------------------------------------------

EXAMPLES

- examples/JdbcSource/DBOrder.rep : this file can be imported into RReport Visual Builder. It requires a ODBC Data Source called RReport that points to the file RReport2.mdb.
- examples/JdbcSource/DBorderTextMode.rep: report designed for text mode printing
- examples/JdbcSource/DBorderExpresions.rep: same report as DBOrder.rep including evaluation of expresions.
- examples/ArraySource/Order.rep : this file can be imported into RReport Visual Builder. This version does not use a database.
- examples/JdbcSource/exampleDBOrder: shows how to print DBOrder.rep. You can run it with runExampleDBOrder.bat.
- examples/ArraySource/exampleOrder: shows how to print Order.rep using an array as data source. You can run it with runExampleOrder.bat.
- examples/PrintByProgram/exampleOrder2: shows how to programatically print Order.rep. You can run it with runExampleOrder2.bat.
- examples/JavaAPI/app.java: includes several examples of the com.java4less.rreport package. These are programatically examples that DO NOT USE the Visual Builder.
- examples/Chart/exampleChart: Report with chart
- examples/ExportReport/: This directory contains several examples for exporting the report to TXT, CSV, PDF, DHTML and XML.
- examples/Groups/Groups.rep: Example of data grouping.
- examples/labels/labels.rep: Example areas printed in several columns.
- examples/XMlSource/xmlorder.rep: Example of xml data source (documents.xml file)


--------------------------------------------------------------------------------------

JAVA PACKAGES

the products contains the following java packages:
- RReport.zip: RReport runtime classes.
- RReportVB.zip: RReport Visual Builder Classes
- rchart.jar: evaluation version of RChart.
- rbarcode.zip: evaluation version of RBarcode.
- rtextpr.jar: evaluation version of RTextPrinter (for Text mode printing)

--------------------------------------------------------------------------------------

ADDITIONAL LIBRARIES

1. In order to run RREPORT VISUAL DESIGNER you must install Swing in your computer. If You still did not do it, you can download it from:

The swing connection: http://java.sun.com/products/jfc/

NOTE 1: RReport (the runtime module) DOES NOT need Swing unless you use the RReportJWindow class.
NOTE 2: if you use jdk 1.3 or later, you don't need to download Swing since it is already included in Java.

2. If you want to export your report to PDF you must download iText: http://www.lowagie.com/iText/

3. If you want to export to DHTML and create PNG files you must download the encoder: http://users.boone.net/wbrameld/pngencoder/ 

4. If you want to export to DHTML and create GIF files you must download the encoder: http://www.acme.com/resources/classes/Acme.tar.gz 

5. If you want to use a XML file as data source you must install xalan 2.6.0 or later (http://xml.apache.org/xalan-j/index.html). You will need the following files RReport's directory: xalan.jar, xml-apis.jar and xecesImpl.jar.


--------------------------------------------------------------------------------------
EVALUATION LICENSE AGREEMENT


IMPORTANT - READ CAREFULLY

This license statement constitutes a legal agreement between you (either as an individual or a single entity) and  for the evaluation version of RAztec including any examples, source code and documentation.

BY DECOMPRESSING, COPYING, OR OTHERWISE USING THE RECEIVED ZIP FILES, YOU AGREE TO BE BOUND BY ALL OF THE TERMS AND CONDITIONS OF THE LICENSE AGREEMENT.

Upon your acceptance of the terms and conditions of the License Agreement, you are granted the use of the Software in the manner provided below.

This Software is protected by copyright law and international copyright treaty. Therefore, you must treat this Software like any other copyrighted material (e.g., a book). 



EVALUATION LICENSE TERMS


1. The evaluation version of the product can only be used for evaluation purposes. 
2. You may not include any component of this version in any final product or application.
3. You may not redistribute any components of this product without this license agreement.
4. You must delete this software after 30 days if you have not pruchased the full version.
5. Reverse engineering, reverse compiling, or disassembly of the Software is expressly prohibited.


TRADE SECRETS


You acknowledge and agree that the structure, sequence and organization of the Software are the valuable trade secrets of Java4Less.com You agree to hold such trade secrets in confidence. 


NO WARRANTY: THE SOFTWARE AND DOCUMENTATION ARE PROVIDED ON AN "AS IS" BASIS AND ALL RISK IS WITH YOU. J4L Components COMPONENTS (http://www.java4less.com) MAKES NO REPRESENTATIONS OR WARRANTIES THAT THE SOFTWARE AND DOCUMENTATION PROVIDED ARE FREE OF ERRORS OR VIRUSES OR THAT THE SOFTWARE AND DOCUMENTATION ARE SUITABLE FOR YOUR INTENDED USE. 

LIMITATION OF LIABILITY: IN NO EVENT SHALL J4L Components COMPONENTS (http://www.java4less.com) OR ITS SUPPLIERS BE LIABLE TO YOU OR ANY OTHER PARTY FOR ANY INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES, LOSS OF DATA OR DATA BEING RENDERED INACCURATE, LOSS OF PROFITS OR REVENUE, OR INTERRUPTION OF BUSINESS IN ANY WAY ARISING OUT OF OR RELATED TO THE USE OR INABILITY TO USE THE SOFTWARE AND/OR DOCUMENTATION, REGARDLESS OF 
THE FORM OF ACTION, WHETHER IN CONTRACT, TORT (INCLUDING NEGLIGENCE), STRICT  PRODUCT LIABILITY OR OTHERWISE, EVEN IF ANY REPRESENTATIVE OF J4L Components COMPONENTS (http://www.java4less.com) OR ITS SUPPLIERS HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. THIS  DISCLAIMER OF LIABILITY FOR DAMAGES WILL NOT BE AFFECTED BY ANY FAILURE OF  THE SOLE AND EXCLUSIVE REMEDIES HEREUNDER.

 

