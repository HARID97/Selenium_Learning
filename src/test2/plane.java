package test2;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class plane {
	
	@Parameters({"URL","Username"})
	@Test
	public void plane1(String URI,String Username) {
		System.out.println(URI);
		System.out.println(Username);
		System.out.println("Plane1");
	}
	
	@Parameters({"URL","Username"})
	@Test
	public void plane2(String URI,String Username) {
		System.out.println(URI);
		System.out.println(Username);
		System.out.println("Plane2");
	}

}
