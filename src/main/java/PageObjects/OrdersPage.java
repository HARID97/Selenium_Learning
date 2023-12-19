package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class OrdersPage extends AbstractComponents{
	
	WebDriver driver;
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> product_names;
	
	public boolean verifyOrderPresent(String productName) {
		boolean flag = product_names.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return flag;
	}

}
