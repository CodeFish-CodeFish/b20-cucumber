package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class QAFoxHomePage {
    //constructor
    public QAFoxHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h4")
    public List<WebElement> itemsList;

    @FindBy(xpath = "//a[text()='Desktops']")
    public WebElement desktopsLink;

    @FindBy(xpath = "//a[text()='Mac (1)']")
    public WebElement macLink;
}
