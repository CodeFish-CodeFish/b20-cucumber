package step_defs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.QAFoxDesktopPage;
import pages.QAFoxHomePage;
import utils.ConfigUtils;
import utils.DriverUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QAFoxStepDefs {

    private WebDriver driver;
    private QAFoxHomePage qaFoxHomePage;
    private QAFoxDesktopPage qaFoxDesktopPage;
    private Map<String, String> itemNamePriceMap = new HashMap<>();
               //itemName, itemPrice
    @When("I navigate to QA Fox home page")
    public void i_navigate_to_qa_fox_home_page() {
        String url = ConfigUtils.getConfigProp("qa_fox");
        driver = DriverUtils.getDriver("chrome");
        driver.get(url);
    }

    @Then("I print out all item names")
    public void i_print_out_all_item_names() {
        qaFoxHomePage = new QAFoxHomePage(driver);

        List<WebElement> elements = qaFoxHomePage.itemsList;
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }

    @Then("I navigate to Desktops -> Mac page")
    public void i_navigate_to_desktops_mac_page() {

        Actions actions = new Actions(driver);
        actions.moveToElement(qaFoxHomePage.desktopsLink).click(qaFoxHomePage.macLink).build().perform();

    }

    @Then("I get item name and price from Mac page")
    public void i_get_item_name_and_price_from_mac_page() {
        qaFoxDesktopPage = new QAFoxDesktopPage(driver);
        String itemName = qaFoxDesktopPage.iMac.getText();
        String itemPrice = qaFoxDesktopPage.iMacPrice.getText();
        itemNamePriceMap.put(itemName, itemPrice);
        System.out.println(itemNamePriceMap);
    }
}






