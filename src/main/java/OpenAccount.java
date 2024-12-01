import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.time.Duration;

public class OpenAccount extends SetUp_Login {
    WebElement OpenNewAccountButton = driver.findElement(By.linkText("Open New Account"));
    WebElement AccType = driver.findElement(By.id("type"));

    @Test
    public void testOpenNewAccount() throws InterruptedException {
        getLoginElements(); // Reusable login method

        OpenNewAccountButton.click();
        AccType.sendKeys("Savings");

        driver.findElement(By.id("fromAccountId")).sendKeys("24888"); // Select a valid account

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"openAccountForm\"]/form/div/input")).click();

        Thread.sleep(1000);
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"openAccountResult\"]/p[1]")).getText();
        String expectedMessage = "Congratulations, your account is now open.";
        AssertJUnit.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void DuplicateAccountCreation() throws InterruptedException{
        getLoginElements(); // Reusable login method

        OpenNewAccountButton.click();
        AccType.sendKeys("Savings");

        WebElement fromAccountDropdown = driver.findElement(By.id("fromAccountId"));
        fromAccountDropdown.sendKeys("24888");

        WebElement openAccountButton = driver.findElement(By.xpath("//input[@value='Open New Account']"));
        openAccountButton.click();
        // Try to create another account immediately after
        driver.get("https://parabank.parasoft.com/parabank/openaccount.htm");

        AccType.sendKeys("SAVINGS");
        fromAccountDropdown.sendKeys("12345");
        openAccountButton.click();

        // Check for an error message or confirmation of duplicate account creation
        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(), 'You already have an account of this type')]"));
        if (errorMessage.isDisplayed()) {
            System.out.println("Test Passed: Duplicate account restriction in place.");
        } else {
            System.out.println("Test Failed: No restriction on duplicate account creation.");
        }
    }


}
