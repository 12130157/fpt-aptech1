import java.awt.*;
import com.java4less.rreport.*;


public class exampleChart extends Frame
{

 public static void main(String[] args) {
        exampleChart f=new exampleChart();
        f.setVisible(true);
		f.init();
 }


 public void init() {

        // load report from file
		RReportJ2 report=new RReportJ2(null);

		if (!report.importReport("chart.rep")) {
            System.out.println("Could not load chart.rep");
            System.exit(0);
		}

		// create preview window
		RReportJWindow Win= new RReportJWindow(report,this);

		// this will print the Header Area
		report.prepare();
		report.endReport();
		Win.show();
 }

 }



