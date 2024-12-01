import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUs extends SetUp{
    @Test
    public void Contact_Us() throws InterruptedException {
        WebElement AboutUs= driver.findElement(By.xpath("//*[@id=\"headerPanel\"]/ul[1]/li[2]/a"));
        AboutUs.click();

        WebElement DemoTxt= driver.findElement(By.className("title"));
        Assert.assertEquals(DemoTxt.getText(),"ParaSoft Demo Website");
        Thread.sleep(1000);

        WebElement WebSiteURL = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p[3]/a"));
        WebSiteURL.click();

        WebElement ContactUsButton= driver.findElement(By.xpath("/html/body/div[2]/header/div/div/div/nav[1]/ul/li[6]/a"));
        ContactUsButton.click();
        Thread.sleep(1000);

        WebElement Email= driver.findElement(By.id("email-7e18a454-1995-49f5-a907-ddc7be450646"));
        Email.sendKeys("marriammohii@gmail.com");

        WebElement FirstName = driver.findElement(By.id("firstname-7e18a454-1995-49f5-a907-ddc7be450646"));
        FirstName.sendKeys("Mariam");

        WebElement LastName = driver.findElement(By.id("lastname-7e18a454-1995-49f5-a907-ddc7be450646"));
        LastName.sendKeys("Mohi");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200);");
        Thread.sleep(2000);

        WebElement Cop = driver.findElement(By.id("company-7e18a454-1995-49f5-a907-ddc7be450646"));
        Cop.sendKeys("SIT");

        WebElement JobTitle = driver.findElement(By.id("jobtitle-7e18a454-1995-49f5-a907-ddc7be450646"));
        JobTitle.sendKeys("Software Tester");

        WebElement Phone = driver.findElement(By.id("phone-7e18a454-1995-49f5-a907-ddc7be450646"));
        Phone.sendKeys("01110524072");


        WebElement Country = driver.findElement(By.id("country-7e18a454-1995-49f5-a907-ddc7be450646"));
        Select EgyCountry=new Select(Country);
        EgyCountry.selectByVisibleText("Egypt");
        Thread.sleep(3000);

        WebElement Comments= driver.findElement(By.id("comments-7e18a454-1995-49f5-a907-ddc7be450646"));
        Comments.sendKeys("bla bla bla");
        Thread.sleep(1000);

        Comments.submit();
        Thread.sleep(3000);

        WebElement ThankYou= driver.findElement(By.xpath("//*[@id=\"main\"]/section[2]/div/div/h2"));
        Assert.assertEquals(ThankYou.getText(),"Thank You!");
        Thread.sleep(1000);
    }

    @Test
    //Leave some required data blank
    public void NegativeTest_Contact_Us() throws InterruptedException {
        WebElement AboutUs= driver.findElement(By.xpath("//*[@id=\"headerPanel\"]/ul[1]/li[2]/a"));
        AboutUs.click();

        WebElement DemoTxt= driver.findElement(By.className("title"));
        Assert.assertEquals(DemoTxt.getText(),"ParaSoft Demo Website");
        Thread.sleep(1000);

        WebElement WebSiteURL = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p[3]/a"));
        WebSiteURL.click();

        WebElement ContactUsButton= driver.findElement(By.xpath("/html/body/div[2]/header/div/div/div/nav[1]/ul/li[6]/a"));
        ContactUsButton.click();
        Thread.sleep(1000);

        WebElement Email= driver.findElement(By.id("email-7e18a454-1995-49f5-a907-ddc7be450646"));
        Email.sendKeys("marriammohii@gmail.com");

        WebElement FirstName = driver.findElement(By.id("firstname-7e18a454-1995-49f5-a907-ddc7be450646"));
        FirstName.sendKeys(" ");

        WebElement LastName = driver.findElement(By.id("lastname-7e18a454-1995-49f5-a907-ddc7be450646"));
        LastName.sendKeys(" ");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200);");
        Thread.sleep(2000);

        WebElement Cop = driver.findElement(By.id("company-7e18a454-1995-49f5-a907-ddc7be450646"));
        Cop.sendKeys("SIT");

        WebElement JobTitle = driver.findElement(By.id("jobtitle-7e18a454-1995-49f5-a907-ddc7be450646"));
        JobTitle.sendKeys("Software Tester");

        WebElement Phone = driver.findElement(By.id("phone-7e18a454-1995-49f5-a907-ddc7be450646"));
        Phone.sendKeys("01110524072");


        WebElement Country = driver.findElement(By.id("country-7e18a454-1995-49f5-a907-ddc7be450646"));
        Select EgyCountry=new Select(Country);
        EgyCountry.selectByVisibleText("Egypt");
        Thread.sleep(3000);

        WebElement Comments= driver.findElement(By.id("comments-7e18a454-1995-49f5-a907-ddc7be450646"));
        Comments.sendKeys("bla bla bla");
        Thread.sleep(1000);

        WebElement ErrorMess = driver.findElement(By.xpath("//*[@id=\"hsForm_7e18a454-1995-49f5-a907-ddc7be450646\"]/fieldset[2]/div[1]/ul/li/label"));
        Assert.assertEquals(ErrorMess.getText(),"Please complete this required field.");
        Thread.sleep(1000);

    }

}
