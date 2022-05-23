package ui_tests.vtex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

import static utilities.ConfigReader.getProperty;

public class ShoppingCartTests extends Driver {
    Logger log = LogManager.getLogger(ShoppingCartTests.class);

    @BeforeMethod
    public void setUp() {
    }

    @Test
    public void AddProductToCartTest() {
        visit(getProperty("url_fila"));
    }


}
