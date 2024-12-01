import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import javax.swing.*;
import java.time.Duration;


public class SetUp {
    WebDriver driver;
    WebDriverWait wait;
    String baseURL = "https://parabank.parasoft.com/parabank/index.htm";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
    }


    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
