package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loan {
	
	
	@Test(groups= {"Smoke"})
	public void loan1(String URL) {
		System.out.println(URL);
		System.out.println("Loan1");
	}
	
	
	@Test()
	public void loan2(String URL) {
		System.out.println(URL);
		System.out.println("Loan2");
	}
	
	@Test
	public void loan3() {
		System.out.println("Loan3");
	}
	
	
	@Test
	public void alpha() {
		System.out.println("Alpha");
	}

}
