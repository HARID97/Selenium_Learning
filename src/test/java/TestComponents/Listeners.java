package TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporterNG;


//to create extent reports
public class Listeners extends BaseTest implements ITestListener{
	
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;
	
//	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //To make tests thread safe when running in parallel
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());
//		extentTest.set(test); //Uncomment if using thread
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS,"test passed");
//		extentTest.get().log(Status.PASS,"test passed"); //Uncomment if using thread
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
//		extentTest.get().fail(result.getThrowable()); //Uncomment if using thread
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		String filePath=null;
		try {
			filePath=getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
//		extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName()); //Uncomment if using thread
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}


	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	
	

}
