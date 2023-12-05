package New_Package;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Parent_Class {
	
	int num=5;
	
	public void method1() {
		System.out.println("Method1");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}

}
