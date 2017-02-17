package pack1;

import mainPack.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import page.contactus.ContactUs;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 20.12.2016.
 */
public class Test2 {
    protected WebDriver driver;

    @BeforeSuite
    @Parameters({ "browserName" })
    public void setup(String browserName) throws Exception {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
    @BeforeClass
    public void start(){
        driver.get("http://www.tacker.ixloo.com/contactus.html");
       driver.findElement(By.className("btn-submit")).click();


        driver.findElement(By.name("first_name")).getClass();
    }

 /*   @BeforeMethod
    @Parameters({ "browserName" })
    public void setup(String browserName) throws Exception {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }*/

    @AfterSuite
    public void tearDown() throws Exception {
        if (driver != null) {
            WebDriverFactory.killDriverInstance();
        }
    }
    @Test
    public void test2(){
        Assert.assertEquals(driver.findElement(By.name("first_name")).getCssValue("border-color"), "rgb(173, 85, 83)");
    }
    @Test
    public void test3(){
        Assert.assertEquals(driver.findElement(By.name("first_name")).getAttribute("class"), "form-control error");

    }
    @Test(enabled=false)
    public void test4() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.name("first_name")).getAttribute("box-shadow"),"rgba(0, 0, 0, 0.075) 0px 1px 1px 0px inset");
        Assert.assertEquals(driver.findElement(By.name("first_name")).isSelected(), true);

    }

    }
