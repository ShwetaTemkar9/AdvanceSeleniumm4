package ListnerUtility;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.baseClass;
import GenericUtility.JavaUtility;

public class ListenerImplementationClassWithExtentReport implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("Report Configuration", true);
		JavaUtility jutil = new JavaUtility();
		String currentTime = jutil.getSysdateandTimeForScreenshot();

		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/Report_" + currentTime + ".html");
		spark.config().setDocumentTitle("Ninza CRM");
		spark.config().setReportName("NCRM Test Execution Report");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("BROWSER", "Firefox");
		report.setSystemInfo("Author", "Anjali");
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		test.log(Status.INFO, "===== " + methodName + " === STARTED ===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.INFO, "===== " + methodName + " === SUCCESS ===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		JavaUtility jutil = new JavaUtility();
		String dateTime = jutil.getSysdateandTimeForScreenshot();
		test = report.createTest(methodName);

		TakesScreenshot tks = (TakesScreenshot)baseClass.sDriver;
		String temp = tks.getScreenshotAs(OutputType.BASE64);

		test.addScreenCaptureFromBase64String(temp, methodName + "_" + dateTime);
		test.log(Status.FAIL, "===== " + methodName + " === FAILED ===");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log("===== " + methodName + " === SKIPPED ===", true);
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		Reporter.log("===== REPORT BACKUP =====", true);
	}
}