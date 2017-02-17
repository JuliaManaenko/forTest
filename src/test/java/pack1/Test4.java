package pack1;

import mainPack.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 21.12.2016.
 */
public class Test4 {
    protected WebDriver driver;
    @BeforeSuite
    @Parameters({ "browserName" })
    public void setup(String browserName) throws Exception {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }
    @BeforeClass
    public void start() {
        driver.get("http://www.tacker.ixloo.com/contactus.html");
    }

    @Test(dataProvider = "firstName")
    public void test4_1(String name, String name2){
        driver.findElement(By.name("first_name")).clear();
        driver.findElement(By.name("first_name")).sendKeys(name);
        driver.findElement(By.className("btn-submit")).click();
        Assert.assertEquals(driver.findElement(By.name("first_name")).getCssValue("border-color"), "rgb(204, 204, 204)");

    }
    @DataProvider(name="firstName")
    public Object[][]getFirstName(){
        return new Object[][]{
                {"John", "John"},
                {"Peter", "Peter"}
        };
    }



    /*
    WebElement select = driver.findElement(By.id("selenium_commands"));
	  Select selectOptions = new Select(select);
	  selectOptions.selectByVisibleText("WebElement Commands");*/
}
