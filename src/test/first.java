package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//running a simple testng test
public class first {
	
	//before and aftermethod will execute once before each test method
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}
	
	@Test(groups= {"Smoke"})
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test
	public void test3() {
		System.out.println("Test3");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}

}
