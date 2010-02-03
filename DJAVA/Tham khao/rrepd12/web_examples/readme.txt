HOT TO RUN THIS EXAMPLE:


1. copy the rreport directory to:

<tomcatdirectory>\webapps



2. edit myreport.jsp and change this line

String applicationDir="C:\\java\\tomcat-5.0.19\\webapps\\rreport\\";   

to point to your directory:

String applicationDir="yourtomcatdirectory\\webapps\\rreport\\";  



3. Start your server and open the following url:


http://localhost:8080/rreport/myreport.jsp


or for PDF format:


http://localhost:8080/rreport/myreport.jsp?FORMAT=PDF

but in this case you must first download and copy iText.jar to  

<tomcatdirectory>\webapps\rreport\WEB-INF\lib

-------------------------------------------------------------------

Notes about the example:

- the displayed report is located in  

<tomcatdirectory>\webapps\rreport\WEB-INF\classes\order.rep

- the images of the report are in

<tomcatdirectory>\webapps\rreport\WEB-INF\classes\com\java4less\images

- the images for the HTML report are in 

<tomcatdirectory>\webapps\rreport\images\com\java4less\images
