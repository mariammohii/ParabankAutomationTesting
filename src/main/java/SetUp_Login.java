import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.swing.*;

public class SetUp_Login {

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



    void getLoginElements() throws InterruptedException {
        // Use JOptionPane to capture username and password from the user
        String username = JOptionPane.showInputDialog(null, "Enter Username:");
        String password = JOptionPane.showInputDialog(null, "Enter Password:");

        // Handle null or empty input if the user cancels
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and Password cannot be empty.");
            return;
        }

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        usernameField.sendKeys(username);

        WebElement passwordField =  driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginBtn.click();

        Thread.sleep(3000);

        // Check if login was successful
        checkLoginSuccess(username, password);
    }
    private void checkLoginSuccess(String username, String password) {
        String expectedMessage;

        if (username.equals("Gro_uppp0229") && password.equals("MBNOT")){
            expectedMessage = "Success"; // Modify as per actual success message
        } else {
            expectedMessage = "Error"; // Modify as per actual error message
        }

        if (expectedMessage.equals("Success")) {
            JOptionPane.showMessageDialog(null, "Login successful for " + username);
            System.out.println("Login should be successful for " + username);
        } else {
            JOptionPane.showMessageDialog(null, "Login failed for " + username);
            System.out.println("Login should fail for " + username);
        }
    }
        @AfterMethod
        public void afterTest() {
            driver.quit();
        }
    }


