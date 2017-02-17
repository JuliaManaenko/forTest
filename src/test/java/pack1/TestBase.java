package pack1;

import mainPack.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 22.12.2016.
 */
public class TestBase {

    protected WebDriver driver;
    @BeforeSuite
    @Parameters({ "browserName" })
    public void setup(String browserName) throws Exception {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() throws Exception {
        if (driver != null) {
            WebDriverFactory.killDriverInstance();
        }
    }
}
