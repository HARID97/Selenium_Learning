package Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.OrderConfirmationPage;
import PageObjects.PlaceOrderPage;
import PageObjects.ProductCatalogue;
import TestComponents.BaseTest;
import TestComponents.Retry;

public class ErrorValidations extends BaseTest{
	
	//retryAnalyzer will make the test case run again if it fails
	@Test(groups= {"ErrorHandling"},retryAnalyzer = Retry.class)
	public void submitOrder() throws IOException {
		
//	String productName="ADIDAS ORIGINAL";
//	String country="India";
	//BeforeMethod annotation in BaseTest is executed first and returns LandingPage object
	ProductCatalogue pc = landingPage.loginToApplication("harilol@hotmail.com", "Hari555.hd");
	Assert.assertEquals(landingPage.getErrorMessage(),"Incorrect email or passwor.");
	}
	
	@Test
	public void ProductErrorValidation() {
		String productName="ADIDAS ORIGINAL";
		String country="India";
		//BeforeMethod annotation in BaseTest is executed first and returns LandingPage object
		ProductCatalogue pc = landingPage.loginToApplication("harilol@hotmail.com", "Hari555.hd!");
		List<WebElement> elements = pc.getProducts();
		pc.addProductToCart(productName);
		CartPage cp = pc.goToCartPage(); //calling method of parent class using object of child class
		Boolean match=cp.verifyItemPresent("ADIDAS ORIGINALS");
		Assert.assertFalse(match);
	}
	
	
	
		
}


