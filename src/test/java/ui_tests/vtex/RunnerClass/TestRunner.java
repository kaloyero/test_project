package ui_tests.vtex.RunnerClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/ui_tests/vtex/FeatureFile", plugin = { "json:target/cucumber-reports/cucumber.json",
        "pretty", "html:target/html-report/cucumber-html-reports.html",
        "junit:target/cucumber-reports/cucumber.xml",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, glue = {
        "ui_tests/vtex/stepDefinitions"},
        tags = "@deleteProduct",
        monochrome = true)
public class TestRunner {

//@tags= {"@DeletePlace"}
}