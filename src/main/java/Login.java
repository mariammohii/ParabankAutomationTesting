import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class Login extends Registration {

    @Test(dependsOnMethods = {"testPositiveRegistration"})
    public void testPositiveLogin() {
        driver.findElement(By.name("username")).sendKeys("Group2");
        driver.findElement(By.name("password")).sendKeys("MBNOT");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        String actualMessage = driver.findElement(By.xpath("//*[@id=\"showOverview\"]/h1")).getText();
        String expectedMessage = "Accounts Overview";
        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void testNegativeLogin()  {
        driver.findElement(By.name("username")).sendKeys("markk");
        driver.findElement(By.name("password")).sendKeys("12345@!mm");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        String actualMessage = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1")).getText();
        String expectedMessage = "Error!";
        assertEquals(actualMessage, expectedMessage);
    }
}
