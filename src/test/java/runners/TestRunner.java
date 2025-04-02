package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {"pretty", 
        	   "html:target/cucumber-reports",
               //"html:target/cucumber-reports/cucumber.html", // Relatório HTML
               //"json:target/cucumber-reports/cucumber.json"  // Relatório JSON
            }
)
public class TestRunner {
}