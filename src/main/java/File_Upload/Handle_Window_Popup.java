package File_Upload;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Handle_Window_Popup {

    WebDriver driver;

    @BeforeClass
    public void initialize_driver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        //Enters username and password in the popup
        driver.get("https:admin:admin@the-internet.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/basic_auth']")).click();

    }

    @AfterClass
    public void close_driver(){
        driver.close();
    }

}
