package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObjects.LandingPage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//common methods used by test classes are defined in this class
public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException {
		
		//declare global properties in properties file and read the data from that file.
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Resources//GlobalData.properties");
		prop.load(fis);
		
		//to read browser value from command
	    //System.getProperty("browser");
		//Using ternary operator to check :  If we are passing browser from terminal, then that browser is used. else uses the browser set in the global file
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		
		
		//for switching between browsers
		//changes made to support headless mode execution
		if(browserName.contains("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			//System.setProperty("webdriver.chrome.driver","C://Users//USER//Downloads//chromedriver-win64//chromedriver-win64/chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));//to run in full screen when running in headless mode
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		//common code for all tests
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("here");
		driver.manage().window().maximize();
		return driver;
	}
	
	//common code to login to application for all tests
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		
		driver=initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.loginTo();
		return landingPage;
	}
	
	//method will run always 
	@AfterMethod(alwaysRun=true)
	public void breakDown() {
		driver.close();
	}
	
	public List<HashMap<String,String>> getJSONData(String filePath) throws IOException {
		File file = new File(filePath);
		String jsonContent = FileUtils.readFileToString(file);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent,new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+testCaseName+".png");
		FileUtils.copyFile(source,file);
		return System.getProperty("user.dir")+testCaseName+".png";
		
	}
	
	

}
