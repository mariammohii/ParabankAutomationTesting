import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Registration extends SetUp {
    @Test
    public void testPositiveRegistration() {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("customer.firstName")).sendKeys("Group2");
        driver.findElement(By.id("customer.lastName")).sendKeys("MBNOT");
        driver.findElement(By.id("customer.address.street")).sendKeys("street 100");
        driver.findElement(By.id("customer.address.city")).sendKeys("Cairo");
        driver.findElement(By.id("customer.address.state")).sendKeys("Cairo");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("110011");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("123456789");
        driver.findElement(By.id("customer.ssn")).sendKeys("123-45-6789");
        driver.findElement(By.id("customer.username")).sendKeys("Gro_uppp0229");
        driver.findElement(By.id("customer.password")).sendKeys("MBNOT");
        driver.findElement(By.id("repeatedPassword")).sendKeys("MBNOT");
        driver.findElement(By.xpath("//input[@value='Register']")).click();

        String actualMessage = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p")).getText();
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void testNegativeRegistration() throws InterruptedException {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("customer.firstName")).sendKeys("Group2");
        driver.findElement(By.id("customer.lastName")).sendKeys("MBNOT");
        driver.findElement(By.id("customer.address.street")).sendKeys("Street 100");
        driver.findElement(By.id("customer.address.city")).sendKeys("Cairo");
        driver.findElement(By.id("customer.address.state")).sendKeys("Cairo");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("110011");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("0987654321");
        driver.findElement(By.id("customer.ssn")).sendKeys("987-65-4321");
        driver.findElement(By.id("customer.username")).sendKeys("Gro_uppp0222");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String actualMessage = driver.findElement(By.id("customer.password.errors")).getText();
        String expectedMessage = "Password is required.";
        String actualMessage1 = driver.findElement(By.id("repeatedPassword.errors")).getText();
        String expectedMessage1 = "Password confirmation is required.";

        assertEquals(actualMessage, expectedMessage);
        assertEquals(actualMessage1, expectedMessage1);
    }
}
