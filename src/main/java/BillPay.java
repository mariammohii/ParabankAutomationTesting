import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class BillPay extends SetUp_Login {
    @Test
    public void testBillPay() throws InterruptedException{
        getLoginElements();
        driver.findElement(By.linkText("Bill Pay")).click();

        //Payee Name
        WebElement Payee_Name= driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[1]/td[2]/input"));
        Payee_Name.sendKeys("Utility Company");
        //Address
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[2]/td[2]/input")).sendKeys("123 Utility St");
        //City
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[3]/td[2]/input")).sendKeys("Utility City");
        //State
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[4]/td[2]/input")).sendKeys("CA");
        //Zip Code
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[5]/td[2]/input")).sendKeys("90001");

        //Phone #
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/form/table/tbody/tr[6]/td[2]/input")).sendKeys("123456789");
        //Account #
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[8]/td[2]/input")).sendKeys("13455");
        //Verify Account #
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[9]/td[2]/input")).sendKeys("13455");

        //Amount
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/form/table/tbody/tr[11]/td[2]/input")).sendKeys("1000");
        //From account #
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[13]/td[2]/select")).sendKeys("13455");

        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/form/table/tbody/tr[14]/td[2]/input")).click();


        Thread.sleep(1000);
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"billpayResult\"]/p[1]")).getText();
        String expectedMessage = "was successful.";
        if (actualMessage.contains(expectedMessage)) {
            System.out.println("Test Passed: Actual text contains expected words.");
        } else {
            System.out.println("Test Failed: Actual text does not contain expected words.");
        }
    }
}
