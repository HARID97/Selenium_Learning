package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	//declared as static
	public static ExtentReports getReportObject() {
		//getting the path for html file generated
				String path = System.getProperty("user.dir")+"\\reports\\index.html";
				//initializing helper class for setting up the configuration. It reports to the main class ExtentReports
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				//Setting the test results name
				reporter.config().setReportName("Web Automation Results");
				//Setting title name
				reporter.config().setDocumentTitle("Test Results");
				
				ExtentReports extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Harikrishnan D");
				return extent;

	}

}
