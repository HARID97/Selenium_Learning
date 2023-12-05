package Screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Screenshot {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		driver.navigate().to("https://google.co.in");
	}
	@Test
	public void takeScreenshot() throws IOException {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("D:\\Screenshots\\screenshot.png"));
	}
	@AfterTest
	public void after_test() {
		driver.close();
		driver.quit();
		
	}

}
