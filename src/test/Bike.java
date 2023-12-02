package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Bike {
	
	//Before and After suites will execute once before and after all the tests in the suite 
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
	
	
	//beforeclass and afterclass will execute once before and after all the tests in the class is defined
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	
	
	@Test(groups= {"Smoke"})
	public void Bike1() {
		System.out.println("Bike1");
	}
	
	@Test
	public void Bike2() {
		System.out.println("Bike2");
	}
	
	@Test
	public void Bike3() {
		System.out.println("Bike3");
	}

}
