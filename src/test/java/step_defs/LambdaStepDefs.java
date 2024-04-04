package step_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.FormDemoPage;
import pages.LambdaHomePage;
import pages.LambdaInputFormPage;
import utils.ConfigUtils;
import utils.DriverUtils;

import java.util.Map;

public class LambdaStepDefs {

    private WebDriver driver;
    private LambdaHomePage lhp;

    private LambdaInputFormPage lifp;

    @Given("I am on Lambda home page")
    public void i_am_on_lambda_home_page() {
        String url = ConfigUtils.getConfigProp("lambda_url");
        driver = DriverUtils.getDriver("chrome");
        driver.get(url);
    }

    @When("I navigate to input form page")
    public void i_navigate_to_input_form_page() {
        lhp = new LambdaHomePage(driver);
        lhp.inputFormLink.click();
    }

    @When("I fill out the form")
    public void i_fill_out_the_form() {


    }

    @When("click submit")
    public void click_submit() {

    }

    @Then("I should see success message")
    public void i_should_see_success_message() {
        FormDemoPage fdp = new FormDemoPage(driver);
        String expectedMessage = "Thanks for contacting us, we will get back to you shortly.";
        String actualMessage = fdp.successMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @When("I fill out the form with following information")
    public void i_fill_out_the_form_with_following_information(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap();

        lifp = new LambdaInputFormPage(driver);

        //retrieving values from data table by keys
        String name = dataMap.get("name");
        System.out.println(name);
        lifp.nameField.sendKeys(name);

        String email = dataMap.get("email");
        System.out.println(email);
        lifp.emailField.sendKeys(email);

        String pWord = dataMap.get("password");
        System.out.println(pWord);
        lifp.passwordField.sendKeys(pWord);

        String company = dataMap.get("company");
        System.out.println(company);
        lifp.companyField.sendKeys(company);

        String website = dataMap.get("website");
        System.out.println(website);
        lifp.websiteField.sendKeys(website);

        String country = dataMap.get("country");
        System.out.println(country);

        Select countryDropDown = new Select(lifp.countryDropDown);
        countryDropDown.selectByVisibleText(country);

        String city = dataMap.get("city");
        System.out.println(city);
        lifp.cityField.sendKeys(city);

        String address1 = dataMap.get("address1");
        System.out.println(address1);
        lifp.addressField.sendKeys(address1);

        String address2 = dataMap.get("address2");
        System.out.println(address2);
        lifp.address2Field.sendKeys(address2);

        String state = dataMap.get("state");
        System.out.println(state);
        lifp.stateField.sendKeys(state);

        String zipCode = dataMap.get("zipCode");
        System.out.println(zipCode);
        lifp.zipField.sendKeys(zipCode);

        lifp.submitButton.click();


    }


}
