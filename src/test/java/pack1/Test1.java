package pack1;

import mainPack.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 20.12.2016.
 */
public class Test1 {
    protected WebDriver driver;
    @BeforeMethod
    @Parameters({ "browserName" })
    public void setup(String browserName) throws Exception {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws Exception{
        driver.get("http://toolsqa.com/automation-practice-form/");
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.id("datepicker")).sendKeys("25.10.1969");
        driver.findElement(By.id("profession-0")).click();
        driver.findElement(By.id("submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("http://toolsqa.com/automation-practice-form/?firstname=&lastname=&sex=Female&profession=Manual+Tester&photo=&continents=Asia&submit="));
        //  Reporter.log("The actual URL is " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "http://toolsqa.com/automation-practice-form/?firstname=&lastname=&sex=Female&profession=Manual+Tester&photo=&continents=Asia&submit=");

    }

    @Test(dataProvider="firstName")
    public void test4(ArrayList<String> names, String url) throws Exception{

        driver.get("http://toolsqa.com/automation-practice-form/");
        driver.findElement(By.name("firstname")).sendKeys(names.get(0).toString());
        driver.findElement(By.name("lastname")).sendKeys(names.get(1).toString());
        driver.findElement(By.id("tool-0")).click();
        driver.findElement(By.id("tool-2")).click();
        WebElement select = driver.findElement(By.id("selenium_commands"));
        Select selectOptions = new Select(select);
        selectOptions.selectByVisibleText("WebElement Commands");
        driver.findElement(By.id("submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(url));
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @DataProvider(name="firstName")
    public Object[][] getFirstName(){
        String fName1 = "John";
        String fName2 = "Peter";
        String lName1 = "Smith";
        String lName2 = "Peterson";

        String url1 = "http://toolsqa.com/automation-practice-form/?firstname=John&lastname=Smith&photo=&tool=QTP&tool=Selenium+Webdriver&continents=Asia&selenium_commands=WebElement+Commands&submit=";
        String url2 = "http://toolsqa.com/automation-practice-form/?firstname=Peter&lastname=Peterson&photo=&tool=QTP&tool=Selenium+Webdriver&continents=Asia&selenium_commands=WebElement+Commands&submit=";

        ArrayList<String> names1 = new ArrayList<String>();
        ArrayList<String> names2 = new ArrayList<String>();

        names1.add(0, fName1);
        names1.add(1, lName1);
        names2.add(0, fName2);
        names2.add(1, lName2);

        return new Object[][]{{names1, url1}, {names2, url2}};
    }
}
