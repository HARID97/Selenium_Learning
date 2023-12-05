package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cartSection']//h3")
	List<WebElement> cart_elements;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	WebElement checkout_button;
	
	public boolean verifyItemPresent(String productName) {
		boolean flag = cart_elements.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return flag;
	}
	
	public PlaceOrderPage checkout() {
		checkout_button.click();
		PlaceOrderPage pop = new PlaceOrderPage(driver);
		return pop;
	}

}
