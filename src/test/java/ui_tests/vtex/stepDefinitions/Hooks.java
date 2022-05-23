package ui_tests.vtex.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Driver;

import java.io.IOException;

public class Hooks extends Driver {


    @Before()
    public void beforeScenario(Scenario scenario) {


    }

    @AfterStep
    public void getScrShot(Scenario scenario) throws Exception {
        getScreenShot(scenario);


    }

    @After
    public void tearDown(Scenario scenario) throws IOException {

        driver.close();
        System.out.println("Driver is closed");

    }
}