package paraller;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class ParallerTest_1 {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origin=*");
        driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
   public void logoTest() {



        WebElement logo = driver.findElement(By.xpath("//*[@alt='company-branding']"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void homePageTest() {



        String title = driver.getTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

    @AfterTest
    void teardown() {
        driver.quit();
    }
}
