package zadTestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @BeforeMethod
    void getUrl() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeTest
    void msgTest() {
        System.out.println("This is a login test");
    }

    @Test
    void loginTest() {
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

        userName.sendKeys("Admin");
        password.sendKeys("admin123");
        loginBtn.click();

        WebElement dashboard = driver.findElement(By.xpath("//*[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
        Assert.assertEquals(dashboard.getText(),"Dashboard");
    }

    @AfterTest
    void endTest() {
        System.out.println("End of test");
    }


    @AfterMethod
    void closeTab() {
        driver.close();
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
