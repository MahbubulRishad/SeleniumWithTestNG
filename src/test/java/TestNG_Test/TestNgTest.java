package TestNG_Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static TestNG_Test.BaseTest.driver;

public class TestNgTest extends BaseTest {
    @Test
    public void verifyLogInPage() {
        String customerLoginPage = driver.findElement(By.cssSelector("#leftPanel h2")).getText().trim();
        Assert.assertEquals(customerLoginPage, "Customer Login");
    }

    @Test
    public void verifyAboutUs() {
        WebElement aboutUsEL = driver.findElement(By.cssSelector(".leftmenu > li:nth-child(2) > a"));
        aboutUsEL.isDisplayed();
        aboutUsEL.click();

//        String parasoftDemoWebsite = driver.findElement(By.cssSelector(".title")).getText().trim();
        Assert.assertTrue(driver.getPageSource().contains("ParaSoft Demo Website"));
    }


    @Test
    public void verifyRegisterLink(){
      WebElement registerLink = driver.findElement(By.xpath("//a[normalize-space() = 'Register']"));
      registerLink.isDisplayed();
      registerLink.click();

//      String SignUpPage = driver.findElement(By.cssSelector("#rightPanel .title")).getText().trim();
        Assert.assertTrue(driver.getPageSource().contains("Signing up is easy!"));
    }
}
