package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormDemoPage {

    public FormDemoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css =  ".success-msg.hidden")
    public WebElement successMessage;
}
