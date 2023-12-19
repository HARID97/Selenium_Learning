package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;


//Implementing Page Object Model
public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver); //initializing driver in parent class from child class
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
//	WebElement elem = driver.findElement(By.xpath("//input[@placeholder='email@example.com']"));
	
	
	@FindBy(xpath="//input[@placeholder='email@example.com']")
	WebElement usernameelem;
	
	@FindBy(xpath="//input[@placeholder='enter your passsword']")
	WebElement passwordelem;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement loginelem;
	
	@FindBy(css="//div[contains(@class,'mb-3')]")
	List<WebElement> elements;
	
	@FindBy(xpath="//div[@id='toast-container']")
	WebElement error_message;
	
	
	/*we are giving return type as ProductCatalogue because we know that after logging into application
	 * the next page is productcatalogue page and we have to use the methods of productcatalogue class.
	 */
	public ProductCatalogue loginToApplication(String username,String password) {
		usernameelem.sendKeys(username);
		passwordelem.sendKeys(password);
		loginelem.click();
		ProductCatalogue pc = new ProductCatalogue(driver);
		return pc;
	}
	
	public void loginTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage() {
		waitForElementToAppear(error_message);
		System.out.println(error_message.getText());
		return error_message.getText();
	}
}
