package ui_tests.appashops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginPageTests extends Driver {
    Logger log = LogManager.getLogger(LoginPageTests.class);

    @BeforeMethod
    public void setUp() {
        visit(ConfigReader.getProperty("url_appashops"));
    }

    @Test
    public void successfulLoginTest() {
    }


}
