package stepdefinitions;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;

public class Hooks {
    @Before(order=1,value="@navigations")
    public void navigateToHomePage(){

        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }

    @After
    public void tearDown(Scenario scenario) {
//
        System.out.println("After Hooks");
        //adding reports that is generated when a scenrio fails
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed scenerio");

        }
        Driver.closeDriver();
    }
}
