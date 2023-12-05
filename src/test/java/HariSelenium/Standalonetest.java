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

import PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalonetest {
	
	public static void main(String args[]) throws InterruptedException {
		
	
	WebDriver driver;
	String productName="ADIDAS ORIGINAL";
	
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		LandingPage page = new LandingPage(driver);
	
	
	
		driver.findElement(By.xpath("//input[@placeholder='email@example.com']")).sendKeys("harilol@hotmail.com");
		driver.findElement(By.xpath("//input[@placeholder='enter your passsword']")).sendKeys("Hari555.hd!");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
		System.out.println("elements count: "+elements.size());
		
		
		WebElement prod = elements.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List<WebElement> elems = driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
		Boolean match = elems.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
		
		Actions actions = new Actions(driver);
		actions.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class,'ta-results')]")));
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Place Order ')]")).click();
		
		String confirmMessage = driver.findElement(By.xpath("//h1")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		
	
	
		Thread.sleep(8000);
		driver.quit();
		
}
		
}


