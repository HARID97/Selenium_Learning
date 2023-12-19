package Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.LandingPage;
import PageObjects.OrderConfirmationPage;
import PageObjects.OrdersPage;
import PageObjects.PlaceOrderPage;
import PageObjects.ProductCatalogue;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderPage extends BaseTest{
	//String productName="ADIDAS ORIGINAL";
	String country="India";
	
	@Test(dataProvider="getData",groups= {"Smoke"})
	public void submitOrder(String email,String password,String productName) throws IOException {
		//BeforeMethod annotation in BaseTest is executed first and returns LandingPage object
		ProductCatalogue pc = landingPage.loginToApplication(email,password);
		List<WebElement> elements = pc.getProducts();
		pc.addProductToCart(productName);
		CartPage cp = pc.goToCartPage(); //calling method of parent class using object of child class
		Boolean match=cp.verifyItemPresent(productName);
		Assert.assertTrue(match);
		PlaceOrderPage pop = cp.checkout();
		pop.selectCountry(country);
		OrderConfirmationPage ocp = pop.place_order();
		String message = ocp.getMessage();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		}
	
	//checking order is dependent on placing order
	@Test(dependsOnMethods= {"submitOrder"},dataProvider="getData",groups= {"Smoke1"})
	public void OrderHistoryTest(String email,String password,String productName) {
		ProductCatalogue pc = landingPage.loginToApplication(email,password);
		OrdersPage op = pc.goToOrdersPage();
		Assert.assertTrue(op.verifyOrderPresent(productName));
		
	}
	
	
	//sending data as multidimensional objects
	@DataProvider
	public Object[][] getData(){
		Object[][] new_object = new Object[2][3];
		new_object[0][0]="harilol@hotmail.com";
		new_object[0][1]="Hari555.hd!";
		new_object[0][2]="ADIDAS ORIGINAL";
		new_object[1][0]="liukang@hotmail.com";
		new_object[1][1]="Liukang@69";
		new_object[1][2]="ZARA COAT 3";
		return new_object;
	}
		
}


