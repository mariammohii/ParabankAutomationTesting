import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductsRequist extends SetUp {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    public void Product_Requist() throws InterruptedException{

        WebElement ProductsSelection= driver.findElement(By.xpath("//*[@id=\"headerPanel\"]/ul[1]/li[4]/a"));
        ProductsSelection.click();

        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1300);");
        Thread.sleep(2000);

        WebElement Solutions = driver.findElement(By.xpath("//*[@id=\"search-filter-form-28131\"]/ul/li[1]/h4"));
        Solutions.click();
        Thread.sleep(1000);
        WebElement option = driver.findElement(By.xpath("//*[@id=\"search-filter-form-28131\"]/ul/li[1]/ul/li[2]/label"));
        option.click();

        js.executeScript("window.scrollBy(0, 200);");
        Thread.sleep(2000);

        WebElement Industry = driver.findElement(By.xpath("//*[@id=\"search-filter-form-28131\"]/ul/li[2]/h4"));
        Industry.click();
        Thread.sleep(1000);
        WebElement option2 = driver.findElement(By.xpath("//*[@id=\"search-filter-form-28131\"]/ul/li[2]/ul/li[1]/label"));
        option2.click();

        js.executeScript("window.scrollBy(0, 400);");
        Thread.sleep(2000);

        WebElement SearchButton = driver.findElement(By.xpath("//*[@id=\"search-filter-form-28131\"]/ul/li[3]/input"));
        SearchButton.click();

        Thread.sleep(3000);
        WebElement ReqDemo= driver.findElement(By.xpath("//*[@id=\"results\"]/div/div[1]/div[1]/div[2]/a"));
        ReqDemo.click();

        Thread.sleep(2000);

        WebElement CompName= driver.findElement(By.id("email-ac031725-1541-4bcb-a4b1-baf748fba09b"));
        CompName.sendKeys("maryam@sitksa-eg.com");

        WebElement FirstName = driver.findElement(By.id("firstname-ac031725-1541-4bcb-a4b1-baf748fba09b"));
        FirstName.sendKeys("Mariam");

        WebElement LastName = driver.findElement(By.id("lastname-ac031725-1541-4bcb-a4b1-baf748fba09b"));
        LastName.sendKeys("Mohi");

        Thread.sleep(1000);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        Thread.sleep(1000);

        WebElement Cop = driver.findElement(By.id("company-ac031725-1541-4bcb-a4b1-baf748fba09b"));
        Cop.sendKeys("SIT");

        WebElement JobTitle = driver.findElement(By.id("jobtitle-ac031725-1541-4bcb-a4b1-baf748fba09b"));
        JobTitle.sendKeys("Software Tester");

        WebElement Phone = driver.findElement(By.id("phone-ac031725-1541-4bcb-a4b1-baf748fba09b"));
        Phone.sendKeys("01110524072");


        WebElement Country = driver.findElement(By.id("country-ac031725-1541-4bcb-a4b1-baf748fba09b"));
        Select EgyCountry=new Select(Country);
        EgyCountry.selectByVisibleText("Egypt");
        Thread.sleep(3000);

        Country.submit();
        Thread.sleep(3000);

        WebElement ThankYou= driver.findElement(By.xpath("//*[@id=\"main\"]/section[2]/div/div/h2"));
        Assert.assertEquals(ThankYou.getText(),"Thank You!");
        Thread.sleep(1000);

    }

}
