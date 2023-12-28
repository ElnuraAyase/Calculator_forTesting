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

public class ParallerTest_2 {
WebDriver driver;
    @BeforeTest
    void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origin=*");
        driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void loginToApp() {
        WebElement username = driver.findElement(By.xpath("//*[@name='username']"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
        password.sendKeys("admin123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        WebElement dashboard = driver.findElement(By.xpath("//*[@class='oxd-topbar-header-breadcrumb']"));

        Assert.assertEquals(dashboard.getText(),"Dashboard");


    }

    @AfterTest
    void tearDown() {
        driver.quit();
    }
}

