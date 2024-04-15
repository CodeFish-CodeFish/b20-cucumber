package step_defs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HerokuappWindowsPage;
import utils.ConfigUtils;
import utils.DriverUtils;

import java.util.List;
import java.util.Set;

public class HerokuappStepDefs {

    WebDriver driver;
    String headerText;

    HerokuappWindowsPage windowsPage;

    @When("I navigate to home page")
    public void i_navigate_to_home_page() {
        driver = DriverUtils.getDriver("chrome");
        String url = ConfigUtils.getConfigProp("url");
        driver.get(url);
    }

    @Then("I should see {int} links")
    public void i_should_see_links(int int1) {
        List<WebElement> linkElementList = driver.findElements(By.xpath("//li//a"));
        int linksCount = linkElementList.size();
        Assert.assertEquals(int1, linksCount);
    }

    @When("I navigate to checkboxes page")
    public void i_navigate_to_checkboxes_page() {
        driver = DriverUtils.getDriver("chrome");
        String url = ConfigUtils.getConfigProp("url2");
        driver.navigate().to(url);
    }

    @Then("I validate page header")

    public void i_validate_page_header() {
        WebElement header = driver.findElement(By.tagName("h3"));
        headerText = header.getText();
        System.out.println(header.getText());
        Assert.assertEquals("Checkboxes", header.getText());
    }


    @When("I navigate to windows page")
    public void i_navigate_to_windows_page() {
        String url = ConfigUtils.getConfigProp("herokuapp_windows");
        driver = DriverUtils.getDriver("chrome");
        driver.get(url);
    }

    @When("I click link")
    public void i_click_link() {
        windowsPage = new HerokuappWindowsPage(driver);
        windowsPage.clickHereLink.click();
    }

    @Then("new tab should open")
    public void new_tab_should_open() {
        Set<String> windowHandles = driver.getWindowHandles();
        Assert.assertTrue(windowHandles.size() > 1);
    }

    @When("I close new tab")
    public void i_close_new_tab() {
        driver.close();
    }

    @Then("I should have {int} tab remaining")
    public void i_should_have_tab_remaining(Integer int1) {
        Set<String> handles = driver.getWindowHandles();
        Assert.assertTrue(handles.size() == 1);
    }

}
