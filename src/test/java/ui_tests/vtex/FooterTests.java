package ui_tests.vtex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MagentoFooterPage;
import utilities.Driver;

import static utilities.ConfigReader.getProperty;

public class FooterTests extends Driver {
    Logger log = LogManager.getLogger(FooterTests.class);
    MagentoFooterPage magentoFooterPage = new MagentoFooterPage();

    @BeforeMethod
    public void setUp() {

    }

    @Test
    public void repentanceFilaArgentinaButtonTest() {
        visit(getProperty("url_fila"));
        magentoFooterPage.clickRepentanceFilaArgentinaButton();
        magentoFooterPage.validateContactsUrl();
        magentoFooterPage.clickThemesList();
    }

    @AfterMethod
    public void tearDown() {
        //closeDriver();
    }
}
