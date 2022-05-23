package ui_tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;

public class SandBoxTests extends Driver {
    Logger log = LogManager.getLogger(SandBoxTests.class);

    // Utilizar esta clase para realizar pruebas de scripts

    @BeforeTest
    public void before() {
        log.info("lets start man");
    }

    @Test
    public void test() {
        log.info("Other Log...");
        log.debug("Other Log...");
        log.fatal("Other Log...");
        log.error("Other Log...");
        log.warn("Other Log...");

        Assert.assertEquals(1, 1);
    }

    @AfterTest
    public void quit() {
        log.info("Other Log...");
    }
}
