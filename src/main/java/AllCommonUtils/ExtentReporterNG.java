package AllCommonUtils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;
	
	public static ExtentReports getReporterObjects()  {
		//ExtentReports , ExtentSparkReporter
		
		
		String ReportPath =System.getProperty("user.dir")+"\\src\\main\\java\\Reports\\index.html";
		
		System.out.println("------------------------"+ReportPath+"--------------------------------");
		ExtentSparkReporter reporter = new ExtentSparkReporter(ReportPath);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Login test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Muhiuddin");
		
		return extent;
		
	}

}
