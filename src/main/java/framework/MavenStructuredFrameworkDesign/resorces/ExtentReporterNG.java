package framework.MavenStructuredFrameworkDesign.resorces;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject() //created static method so that this method can directly access without creating object with class.methodName
	{
		String path= System.getProperty("user.dir")+ "\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path); //aspect the path where your report should be created
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Deepak Kumar");
		return extent;
	}

}
