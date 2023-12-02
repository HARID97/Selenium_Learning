package test2;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class train {
	
	//before and aftertest will execute once before each test folder(test tag in xml file in which the class is defined)
	@BeforeTest
	public void beforetest() {
		System.out.println("Going to run test case");
	}
	
	//passing parameter from testng
	//can pass more than one parameter in the same method from testng xml
	@Parameters({"URL","Username"})
	@Test
	public void train1(String urlname,String username) {
		System.out.println(urlname);
		System.out.println(username);
		System.out.println("Train1");
	}
	
	@Parameters({"URL","Username"})
	@Test
	public void train2(String URL,String username) {
		System.out.println(URL);
		System.out.println(username);
		System.out.println("Train2");
	}
	
	@AfterTest
	public void after_test() {
		System.out.println("Test case executed");
	}
}
