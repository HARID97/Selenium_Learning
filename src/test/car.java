package test;

import org.testng.annotations.Test;

public class car {
	
	//adding group tests
	@Test(groups={"Smoke"})
	public void car1() {
		System.out.println("Car1");
	}
	
	@Test
	public void car2() {
		System.out.print("Car2");
	}
	
	@Test
	public void car3() {
		System.out.println("Car3");
	}

}
