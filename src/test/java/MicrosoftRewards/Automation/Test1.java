package MicrosoftRewards.Automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	
	public WebDriver driver;
	DataFormatter dataformatter = new DataFormatter();
	String[] search_array={"Australia","USA","Sweden","China","Japan","Norway","Philipines"};
	List<String> list1 = Arrays.asList(search_array);
	
	
	@BeforeTest
	public void before() {
		
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
//		options.addArguments("inprivate");
		driver = new EdgeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		System.out.println(list1);
		
		
		
	}
	
	@Test(dataProvider="rewards")
	public void rewards(String username,String password) throws InterruptedException {
		driver.navigate().to("https://www.microsoft.com/en-in/rewards/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Rewards']/parent::a"))));
		driver.findElement(By.xpath("//div[@id='mectrl_headerPicture']")).click();
		System.out.println("Username: "+username);
		System.out.println("Password: "+password);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='email']"))));
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@class='logo']"))));
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@data-report-value='Submit']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Stay signed in?']"))));
		driver.findElement(By.xpath("//button[@id='declineButton']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Rewards']/parent::a"))));
		
		driver.findElement(By.xpath("//a[text()='PC']")).click();
		
	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Copilot']"))));
		driver.findElement(By.xpath("//textarea")).sendKeys("India");
		driver.findElement(By.xpath("//textarea")).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='b_logoArea']"))));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		driver.findElement(By.xpath("//textarea[@class='b_searchbox']")).clear();
		for(int i=0;i<7;i++) {
			driver.findElement(By.xpath("//textarea[@class='b_searchbox']")).clear();
			driver.findElement(By.xpath("//textarea[@class='b_searchbox']")).sendKeys(list1.get(i));
			driver.findElement(By.xpath("//textarea")).sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//textarea[@class='b_searchbox']")).clear();
		}
		Thread.sleep(3000);
		driver.get("https://www.microsoft.com/en-in/rewards/");
		driver.findElement(By.xpath("//div[@id='mectrl_headerPicture']")).click();
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Rewards']/parent::a"))));
		
		
		
		Thread.sleep(3000);
		
		
	}
	
	@AfterTest()
	public void after() {
		driver.quit();
	}
	
	@DataProvider(name="rewards")
	public Object[][] getData() throws IOException{
		
		FileInputStream fis = new FileInputStream("C://Users//harikrishnan.dileep//Documents//Book1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet4");
		int rowcount = sheet.getPhysicalNumberOfRows();
		System.out.println("RowCount: "+rowcount);
		XSSFRow row = sheet.getRow(0);
		int colcount = row.getLastCellNum();
		System.out.println("Column count: "+colcount);
		
		Object data[][]=new Object[rowcount-1][colcount];
		for(int i=0;i<rowcount-1;i++) {
			row=sheet.getRow(i+1);
			for(int j=0;j<colcount;j++) {
				XSSFCell c = row.getCell(j);
				data[i][j]=dataformatter.formatCellValue(c);
			}
		}
		return data;	
	}

}
