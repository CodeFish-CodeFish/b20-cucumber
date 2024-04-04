package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {

    //constructor
    public FacebookLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "pass")
    public WebElement passwordField;

    @FindBy(name = "login")
    public WebElement loginButton;

    @FindBy(xpath = "//*[text()='The email you entered isn’t connected to an account. ']")
    public WebElement error;


    public void loginToFacebook(String username, String password){
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }




}
