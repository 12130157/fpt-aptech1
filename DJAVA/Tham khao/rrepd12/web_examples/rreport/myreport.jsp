<%@ page import="com.java4less.rreport.*" %>
<%
       
// CONFIGURE THIS!      
String applicationDir="C:\\java\\tomcat-5.0.19\\webapps\\rreport\\";  




String filename="report"+ System.currentTimeMillis() +".pdf";
String pdfExportDir=applicationDir;
String format="DHTML";
String pdfPrefixDir="";
String imagesHTMLPrefixDir="images/";
String imagesExportDir=applicationDir+"images"+ java.io.File.separator;

               
System.out.println("Working directory: " + new java.io.File("dummy.txt").getAbsolutePath());
System.out.println("Format: " + format);
System.out.println("PDF export Dir: " + pdfExportDir);
System.out.println("PDF file: " + filename);
System.out.println("PDF file subdirectory: " + pdfPrefixDir);
System.out.println("HTML images export Dir: " + imagesExportDir);
System.out.println("HTML images subdirectory: " + imagesHTMLPrefixDir);
System.out.println("Format: " + format);


			  


   
    // read format parameter	
    if (request.getParameter("FORMAT")!=null) format= request.getParameter("FORMAT");


    RReportJ2 rep=new RReportJ2(null);
    String reportFile="order.rep";


    System.out.println("Report file is " +reportFile);


    java.net.URL fileURL=null;
    // load as resource the REP file must be located in the classpath, for example in WEB-INF/classes
   if (this.getClass().getClassLoader()!=null) 
		fileURL=this.getClass().getClassLoader().getResource(reportFile);
                
    if (fileURL==null) fileURL=ClassLoader.getSystemResource(reportFile);
   

    if (fileURL==null) 
      throw new ServletException("File " +  reportFile +" could not be loaded as resource");

    if (!rep.importReport(fileURL)) throw new ServletException("File " +  reportFile +" could not be loaded");


    // prepare report for exporting, make sure all printing options are disabled
    rep.disablePrinting(true);
    rep.showProgressWindow=false;
    rep.showPageDialog=false;
    rep.showPrintDialog=false;



     System.out.println("Report loaded");

     rep.exportDirectory=imagesExportDir;
     rep.imagesHTMLPrefix=imagesHTMLPrefixDir;

      // enable or disable HTML
      if (format.toUpperCase().compareTo("PDF")==0) {
                      rep.setHTMLActive(false);
      
      }   else {
                      rep.setHTMLActive(true);
                      rep.setHTMLPages(false);

      }


     // run report now
     System.out.println("Running report");

     rep.prepare();
     rep.endReport();


     // send now report to client

     if (format.toUpperCase().compareTo("PDF")==0) {
        	       // SEND RESPONSE PDF
                       rep.exportPDF(new java.io.FileOutputStream(pdfExportDir+filename));
                       response.setContentType("application/pdf");
                       System.out.println("Redirection to: "+pdfPrefixDir+filename);
                       response.sendRedirect(pdfPrefixDir+filename);
                       // avoid caching in browser
		       response.setHeader ("Pragma", "no-cache");
        	       response.setHeader ("Cache-Control", "no-cache");
        	      response.setDateHeader ("Expires",0);
     }
     else { // HTML
        			   // SEND HTML RESPONSE
                       response.setContentType("text/html");
                       // avoid caching in browser
		       response.setHeader ("Pragma", "no-cache");
        	       response.setHeader ("Cache-Control", "no-cache");
        	       response.setDateHeader ("Expires",0);
                       System.out.println("HTML Output: "+rep.getHTML().length()+" bytes");
                       out.write(rep.getHTML());
                       out.close();
     }





%>