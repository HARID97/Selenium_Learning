package test2;

import org.testng.annotations.Test;

public class helper_attributes_examples {
	
	//dependsOnMethods,enabled,groups,dataProvider and timeout
	
	@Test(dependsOnMethods= {"theta","beta"})
	public void alpha() {
		System.out.println("Alpha");
	}
	
	//ignores test case
	@Test(enabled=false)
	public void gama() {
		System.out.println("Gama");
	}
	
	@Test(timeOut=5000)
	public void theta() {
		System.out.println("Theta");
	}
	
	@Test(dependsOnMethods= {"theta"})
	public void beta() {
		System.out.println("Beta");
	}

}
