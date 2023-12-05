package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[contains(@class,'mb-3')]")
	List<WebElement> items;
	
	@FindBy(css=".ng-animating")
	WebElement element;
	
	
	
	By productsBy = By.xpath("//div[contains(@class,'mb-3')]");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.xpath("//div[@id='toast-container']");
	
	public List<WebElement> getProducts(){
		
		waitForElementToAppear(productsBy);
		return items;
	}
	public WebElement getProductByName(String productName) {
		
		WebElement prod = getProducts().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addProductToCart(String productName) {
		getProductByName(productName).findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(element);
	}
	
	
	
	

}
