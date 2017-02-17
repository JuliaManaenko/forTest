package pages;


import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

/**
 * Created by Julia on 22.12.2016.
 */
public abstract class Page {


    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        String pageUrl = driver.getCurrentUrl();
        return pageUrl;
    }
}
