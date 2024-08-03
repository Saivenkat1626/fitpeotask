package utility;

import java.io.File;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listner implements ITestListener {

	public ExtentSparkReporter reporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext context) {
		File extentReportFile = new File(System.getProperty("user.dir")+"\\Markify_TestNG1\\extentReport.html");
		reporter=new ExtentSparkReporter(extentReportFile);
		reporter.config().setDocumentTitle("Markify Application Report");
		reporter.config().setReportName("Markify Seller");
		reporter.config().setTheme(Theme.STANDARD);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("user", "sai");
		extent.setSystemInfo("Environment", "dev");
		extent.setSystemInfo("browser", "firefox");	
	}
	public void onTestSucess(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	public void onTestFail(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
	}
	public void onTestSkip(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	public void onTestFinish(ITestContext context) {
		extent.flush();
		
}
	}
