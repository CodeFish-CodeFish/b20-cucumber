package step_defs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class GoogleStepDefs {

    WebDriver driver;

    @Given("I am on google home page")
    public void i_am_on_google_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }

    @When("I search for Codefish")
    public void i_search_for_codefish() {
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Codefish" + Keys.ENTER);
    }

    @Then("I should get results")
    public void i_should_get_results() {
        WebElement results = driver.findElement(By.cssSelector("#result-stats"));
        String resultsText = results.getText();
        System.out.println(resultsText);
    }


}
