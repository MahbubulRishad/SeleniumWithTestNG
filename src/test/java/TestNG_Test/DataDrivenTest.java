package TestNG_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest extends BaseTest{

    @DataProvider(name = "DummyData")
    public Object[][] getDummyData(){
        return new Object[][] {{"Username1", "Password1"}, {"Username2", "Password2"}, {"Username3", "Password3"}, {"Username4", "Password4"}};
    }

    @Test(dataProvider = "DummyData")
    public void loginShouldSucceed(String username, String password) throws InterruptedException {
        WebElement usernameEl = driver.findElement(By.xpath("//input[@name = \"username\"]"));
        usernameEl.isDisplayed();
        usernameEl.clear();
        usernameEl.sendKeys(username);
        Thread.sleep(3000);

        WebElement passwordEl = driver.findElement(By.xpath("//input[@name = \"password\"]"));
        passwordEl.isDisplayed();
        passwordEl.clear();
        passwordEl.sendKeys(password);
        Thread.sleep(3000);
    }
}
