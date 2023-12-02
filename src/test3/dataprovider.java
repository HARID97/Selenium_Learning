package test3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
	
	@Test(dataProvider="getData")
	public void test1(String champname,String ultname) {
		System.out.println(champname + ": "+ultname);
	}
	
	@DataProvider
	public Object getData() {
		//each row is a dataset
		Object[][] data = new Object[3][2];
		data[0][0] = "Sion";
		data[0][1] = "Unstoppable Onslaught";
		data[1][0] = "Karthus";
		data[1][1] = "Requiem";
		data[2][0] = "Shen";
		data[2][1] = "Stand United";
		
		return data;
		
	}

}
