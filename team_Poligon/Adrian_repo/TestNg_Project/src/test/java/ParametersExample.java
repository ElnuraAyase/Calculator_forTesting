import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParametersExample {
    WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "url"})
    void setUp(String browser, String app) {

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);


        } else if (browser.equalsIgnoreCase("edge")) {

            EdgeOptions options = new EdgeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--remote-allow-origins=*");
            driver = new EdgeDriver(options);

        }

        driver.get(app);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    void logoTest() {
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img"));


        Assert.assertTrue(logo.isDisplayed(), "Logo not displayed");

    }

    @Test
    void homePageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

    @AfterClass
    void tearDown() {
       driver.quit();
    }
}
