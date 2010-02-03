ECHO ON
ECHO 
ECHO ***** Warning ****
ECHO RReport Visual Builder requires Swing if you use java 1.1 or 1.2:
ECHO you can download swing at:
ECHO http://java.sun.com/products/jfc/
ECHO 
ECHO Other Additional (optional) libraries
ECHO - iText (http://www.lowagie.com/iText/): required if you want to create PDF files
ECHO - Xalan Apache (http://xml.apache.org/xalan-j/index.html): required if you want to use a XML file as data source:
ECHO * 
ECHO *
ECHO *
ECHO ON
java.exe -cp ".;rtextpr.jar;images;swingall.jar;rreport.zip;rreportVB.zip;rbarcode.zip;iText.jar;rchart.jar;xalan.jar;xml-apis.jar;xecesImpl.jar" com.java4less.rreportVB.RVReport