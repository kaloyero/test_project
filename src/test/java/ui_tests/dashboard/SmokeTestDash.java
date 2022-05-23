package ui_tests.dashboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utilities.ConfigReader.getProperty;

public class SmokeTestDash extends Driver {

    Logger log = LogManager.getLogger(SmokeTestDash.class);

    @BeforeTest
    public void setUp() {
        log.info("Validation and navigation of the links located on the home page of each brand");
    }

    @DataProvider(name="users")
    public Object[][] stores() {
        return new Object[][]{
                {"url_dashboard2",}
        };
    }

    @Test(priority = 1, dataProvider = "stores")

    public void navigationValidationToTheLinksOfEachBrand(String store) {
        visit(getProperty(store));
        isThereJSErrorOnThePage();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        ArrayList<String> valid_links = new ArrayList<>();
        String flag = ""; // A flag is added so that the link is not repeated

        log.info("Total links found → " + links.size());

        for (WebElement link : links) {
            log.info(link.getAttribute("href"));
            if (link.getAttribute("href") != null && link.getAttribute("href").contains("http") && !link.getAttribute("href").equals(flag)) {
                valid_links.add(link.getAttribute("href"));
                flag = link.getAttribute("href");
            }
        }

        log.info("Total of valid links found → " + valid_links.size());

        int i = 0;
        for (String href : valid_links) {
            log.info((++i) + ":: Navigate to URL with href: " + href);
            driver.navigate().to(href);
        }
    }

    public boolean isThereJSErrorOnThePage() {
        Set<String> errorStrings = new HashSet<>();
        errorStrings.add("SyntaxError");
        errorStrings.add("EvalError");
        errorStrings.add("ReferenceError");
        errorStrings.add("RangeError");
        errorStrings.add("TypeError");
        errorStrings.add("URIError");
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            for (String errorString : errorStrings) {
                if (logEntry.getMessage().contains(errorString)) {
                    log.error("Java Script error has been detected:");
                    log.error(logEntry.getLevel() + " " + logEntry.getMessage());
                    return true;
                }
            }
        }
        return false;
    }


    @AfterTest
    public void teardown() { /*closeDriver();*/}



}
