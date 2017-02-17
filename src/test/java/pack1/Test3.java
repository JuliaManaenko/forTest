package pack1;

import mainPack.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 21.12.2016.
 */
public class Test3 {
    protected WebDriver driver;
    FileInputStream fis;
   // BufferedReader fis = null;

    Properties property = new Properties();


    @BeforeSuite
    @Parameters({ "browserName" })
    public void setup(String browserName) throws Exception {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }
    @BeforeClass

    public void start() throws IOException {
       fis = new FileInputStream("src/test/resourses/config.properties");
     //   fis = new BufferedReader(new FileReader("src/test/resourses/config.properties"));
               property.load(fis);
        driver.get(property.getProperty("url1"));
       // driver.get("http://www.tacker.ixloo.com/contactus.html");
    }
    @AfterSuite
    public void tearDown() throws Exception {
        if (driver != null) {
            WebDriverFactory.killDriverInstance();
        }
    }
    @Test
    public void test3_1() {
        Actions action = new Actions(driver);
        Action mouseOver = action.moveToElement(driver.findElement(By.className("btn-submit"))).build();
        mouseOver.perform();
        Assert.assertEquals(driver.findElement(By.className("btn-submit")).getCssValue("background-color"), "rgba(40, 96, 144, 1)");

    }
}
