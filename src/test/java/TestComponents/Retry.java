package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//Implementation for running the failed tests in selenium
public class Retry implements IRetryAnalyzer{
	
	int count=0;
	int maxTry=2;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxTry) {
			count++;
			return true;
		}
		return false;
	}
	
	

}
