package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // provides us an ability to run
@CucumberOptions(
        features = "src/test/resources/features", //specify where all features are located
        glue = "step_defs", // step definitions
        tags = "@closeTab",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports/index.html", "json:target/cucumber-reports/report.json"}
)

public class Runner {

}
