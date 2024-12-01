import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import org.testng.AssertJUnit;


public class AccountOverview extends SetUp_Login {

    @Test
    public void testAccountsOverview() throws InterruptedException {
        getLoginElements();

        Thread.sleep(100);
        driver.findElement(By.linkText("Accounts Overview")).click();
        String actualMessage = driver.findElement(By.xpath("//*[@id='showOverview']/h1")).getText();
        String expectedMessage = "Accounts Overview";
        AssertJUnit.assertEquals(actualMessage, expectedMessage);
    }
}
