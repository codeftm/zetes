package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/html-reports/failed-cucumber-zetes-report.html",
                "json:target/json-reports/failed-cucumber.json",
                "junit:target/xml-report/failed-cucumber.xml",
                "rerun:target/failedRerun.txt"
        },
        features = "@target/failedRerun.txt",
        glue = {"stepdefinitions"},
        dryRun = false
)
public class FailedRunner {
}
