package pack1;

import mainPack.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 27.01.2017.
 */
public class Test5 {
    protected WebDriver driver;
    WebDriverWait wait;

    @Test
    @Parameters({ "browserName" })
    public void test1(String browserName){
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.get("http://www.tacker.ixloo.com/dms");
        wait = new WebDriverWait(driver, 25);
        wait.until(jsLoad);
        driver.findElement(By.id("login")).sendKeys("julia.manaenko");
        driver.findElement(By.id("password")).sendKeys("montana123456");
        driver.findElement(By.id("login2")).click();
        wait.until(jsLoad);
        Actions action = new Actions(driver);

        WebElement toolsMenu = driver.findElements(By.cssSelector(".v9-main-item.v9_sub")).get(3);
        Action moveToElem = action.moveToElement(toolsMenu).build();
        moveToElem.perform();

       // manager.getWebDriverHelper().wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a:contains('Reviews')")));
        WebElement toolMenuItemReviews = driver.findElement(By.cssSelector("a[href='/dms/tools/reviews']"));
        toolMenuItemReviews.click();
    }

    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        }
    };
}
