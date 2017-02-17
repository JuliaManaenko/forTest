package page.contactus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;
import org.openqa.selenium.support.How;

/**
 * Created by Julia on 22.12.2016.
 */
public class ContactUs extends Page {
    @FindBy(how = How.XPATH, using = "//input[@name='first_name']")
    private WebElement firstNameInput;

    @FindBy(how = How.XPATH, using = "//input[@class='form-control']")
    private WebElement submitButton;

    public ContactUs(WebDriver driver) {
        super(driver);
    }

    public void clickOnSubmit(){
    submitButton.click();
    }
}
