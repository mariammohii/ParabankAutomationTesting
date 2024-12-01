import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class TrunsferFund extends SetUp_Login {
    public void testTransferFunds() throws InterruptedException {
        getLoginElements();

        driver.findElement(By.linkText("Transfer Funds")).click();
        driver.findElement(By.id("amount")).sendKeys("1000");
        driver.findElement(By.id("fromAccountId")).sendKeys("13455"); // Select valid account
        driver.findElement(By.id("toAccountId")).sendKeys("13455"); // Select valid account

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Transfer']")).click();

        Thread.sleep(1000);
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"showResult\"]/p[1]")).getText();
        String expectedMessage = "has been transferred";
        if (actualMessage.contains(expectedMessage)) {
            System.out.println("Test Passed: Actual text contains expected words.");
        } else {
            System.out.println("Test Failed: Actual text does not contain expected words.");
        }
    }
}


