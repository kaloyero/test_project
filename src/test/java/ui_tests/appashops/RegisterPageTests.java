package ui_tests.appashops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class RegisterPageTests extends Driver {
    Logger log = LogManager.getLogger(RegisterPageTests.class);

    @BeforeMethod
    public void setUp() {
        visit(ConfigReader.getProperty("url_appashops"));
    }

    @Test
    public void successfulRegistrationTest() {
    }

//    @AfterMethod
//    public void tearDown() {
//        closeDriver();
//    }
    @Test
    public void productsOnCarts (){

        visit("https://appashops.com.ar");

    }


}
