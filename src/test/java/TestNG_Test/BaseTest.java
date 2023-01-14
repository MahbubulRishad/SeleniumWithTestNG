package TestNG_Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    @BeforeClass
    public void browserSetUp()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://parabank.parasoft.com/parabank");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
