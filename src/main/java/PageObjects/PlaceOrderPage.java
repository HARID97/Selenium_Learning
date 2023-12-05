package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class PlaceOrderPage extends AbstractComponents{
	
	WebDriver driver;
	
	public PlaceOrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement select_country;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement country_select;
	
	@FindBy(xpath="//*[contains(text(),'Place Order ')]")
	WebElement place_order;
	
	By search_res = By.xpath("//section[contains(@class,'ta-results')]");
	
	public void selectCountry(String country) {
		Actions actions = new Actions(driver);
		actions.sendKeys(select_country,country).build().perform();
		waitForElementToAppear(search_res);
		country_select.click();
		
	}
	
	public OrderConfirmationPage place_order() {
		place_order.click();
		OrderConfirmationPage ocp = new OrderConfirmationPage(driver);
		return ocp;
	}
}
