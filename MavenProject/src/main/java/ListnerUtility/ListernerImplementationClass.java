package ListnerUtility;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.BaseClassFinder;

import BaseClass.baseClass;
import GenericUtility.JavaUtility;

public class ListernerImplementationClass implements ITestListener, ISuiteListener  {

	

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
		Reporter.log("Report Configuration",true);
	}

	

	@Override
	public void onTestStart(ITestResult result) {
		//every @Test annotated method
		String methodName = result.getMethod().getMethodName();
		Reporter.log("==========="+methodName+"=======STARTED======",true);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		Reporter.log("==========="+methodName+"=======SUCCESS======",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
	JavaUtility jutil = new JavaUtility();
	String dateTime= jutil.getSysdateandTimeForScreenshot();
	TakesScreenshot tks= (TakesScreenshot)baseClass.sDriver;
	File temp= tks.getScreenshotAs(OutputType.FILE);
	File perm= new File("./Errorshots/"+methodName+dateTime+"png");
	
	try {
		FileHandler.copy(temp,perm);
	}catch(IOException e)
	{
		e.printStackTrace();
		
	}		Reporter.log("==========="+methodName+"=======FAILED======",true);

	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		Reporter.log("==========="+methodName+"=======SUCCESS======",true);
	}
	
	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("==========="+"=======fINISHED======",true);

	}

}