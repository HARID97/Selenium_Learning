package File_Upload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class FileUpload {


    WebDriver driver;

    @BeforeClass
    public void initialize_driver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        //open chrome instance as incognito
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws IOException, InterruptedException {
        driver.get("https://altoconvertpdftojpg.com/");
        driver.findElement(By.xpath("//button[@id='browse']")).click();
        Runtime.getRuntime().exec("C:\\Users\\USER\\IdeaProjects\\Selenium_New\\FileUpload.exe");
        Thread.sleep(5000);
    }


    @AfterClass
    public void close_driver(){
        driver.close();
    }

}
