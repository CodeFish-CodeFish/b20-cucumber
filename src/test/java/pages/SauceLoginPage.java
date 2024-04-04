package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {

    //constructor
    public SauceLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;


    @FindBy(tagName = "h3")
    public WebElement error;


    public String getErrorMessage() {
        String errorMessage = error.getText();
        return errorMessage;
    }


    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }


}
