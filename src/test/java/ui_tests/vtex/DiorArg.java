package ui_tests.vtex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HeaderPage;
import utilities.Driver;

import static utilities.ConfigReader.getProperty;

public class DiorArg extends Driver {
    public static Logger log = LogManager.getLogger(admitOne.class);
    public String productName, productPrice;

    @Test(description = "login flow")
    public void loginCheck() {


        try {

            visit(getProperty("url_babaycottons"));
            VtexPage_babyCotton.loginCheck();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void Register() {

        try {

            visit(getProperty("url_dior"));
            VtexPage_babyCotton.registerUserDior();
            VtexPage_babyCotton.enterTokenDior();

            //VtexPage_babyCotton.registerCheck();
            //VtexPage_babyCotton.MailinatorChecking();
            //VtexPage_babyCotton.enterTokenAndPassword();
            //Driver.catch_brokenImages();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "create account and change password from my account page ")
    public void myAccChangePass() {

        try {

            visit(getProperty("url_babaycottons"));
            VtexPage_babyCotton.registerCheck();
            VtexPage_babyCotton.MailinatorChecking();
            VtexPage_babyCotton.enterTokenAndPassword();
            VtexPage_admitOne.PopUpGracias(VtexPage_babyCotton.popUpNoButton);
            VtexPage_babyCotton.myAccountDetailCheck();
            VtexPage_babyCotton.myAccountChangePassword();


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "place order successfully ")
    public void placeOrderSuccessfully() {

        try {
            visit(getProperty("url_babaycottons"));
            VtexPage_babyCotton.registerCheck();
            VtexPage_babyCotton.MailinatorChecking();
            VtexPage_babyCotton.enterTokenAndPassword();
            VtexPage_admitOne.PopUpGracias(VtexPage_babyCotton.popUpNoButton);
            VtexPage_babyCotton.babySearchProduct("Toalla");
            VtexPage_babyCotton.cartCheckOut();
            VtexPage_babyCotton.cartPageDetailFill();
            VtexPage_babyCotton.paymentCashOption();
            VtexPage_babyCotton.MailinatorToForOrderConfirmation();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "delete the product from cart and add it again")
    public void deleteProductFrmCart() {

        try {

            visit(getProperty("url_babaycottons"));
            VtexPage_babyCotton.babySearchProduct("Toalla");
            VtexPage_babyCotton.cartCheckOut();
            VtexPage_admitOne.PopUpGracias(VtexPage_babyCotton.popUpNoButton);
            VtexPage_babyCotton.deleteItemCart(VtexPage_babyCotton.emptyCartMsg, VtexPage_babyCotton.cartPgLogo);
            VtexPage_babyCotton.babySearchProduct("body");
            VtexPage_babyCotton.cartCheckOut();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


}
