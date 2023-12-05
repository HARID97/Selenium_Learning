package HariSelenium;

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
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.LandingPage;
import PageObjects.OrderConfirmationPage;
import PageObjects.PlaceOrderPage;
import PageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderPage {
	
	public static void main(String args[]) throws InterruptedException {
		
	
	WebDriver driver;
	String productName="ADIDAS ORIGINAL";
	String country="India";
	
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.navigate().to("https://rahulshettyacademy.com/client");
	driver.manage().window().maximize();
	
	
	LandingPage page = new LandingPage(driver);
	page.loginTo();
	ProductCatalogue pc = page.loginToApplication("harilol@hotmail.com", "Hari555.hd!");
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
	driver.quit();
	
	}
		
}


