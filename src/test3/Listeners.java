package test3;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

//They listen to the results of events
public class Listeners implements ITestListener{
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Successfully executed the test case");
		System.out.println("The test which passed is: "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed successfully");
		System.out.println("The test which failed is: "+result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println();
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println();
	}
	
	public void onTestStart(ITestContext context) {
		System.out.println();
	}
	
	public void onStart(ITestContext context) {
		
	}
	
	public void onFinish(ITestContext context) {
		
	}
	

}
