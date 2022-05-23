package ui_tests.vtex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import static utilities.ConfigReader.getProperty;

public class vitaminaarg extends Driver {
    public static Logger log = LogManager.getLogger(vitaminaarg.class);
    public String productName, productPrice;
//
//    @BeforeTest
//    public void RunSetup() {
//
//        try {
//            visit(getProperty("url_vitamina"));
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("failed due to :::" + e.getMessage());
//            Assert.fail(e.getMessage());
//        }
//
//
//    }

    @Test(description = "Cross Site Validation")
    public void CrossSiteValidation() {

        try {
            visit(getProperty("url_vitamina"));
            VtexPage_admitOne.closeNewsLetter();
            VtexPage_babyCotton.registerCheck();
            VtexPage_babyCotton.MailinatorChecking();
            VtexPage_babyCotton.enterTokenAndPassword();
            Driver.catch_brokenImages();
            Driver.navigateCrossWebSite();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void Register() {


        try {

            visit(getProperty("url_vitamina"));
            VtexPage_admitOne.closeNewsLetter();
            VtexPage_babyCotton.registerCheck();
            VtexPage_babyCotton.MailinatorChecking();
            VtexPage_babyCotton.enterTokenAndPassword();
            //Driver.catch_brokenImages();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "delete the product from cart and add it again")
    public void deleteProductFrmCart() {


        try {
            visit(getProperty("url_vitamina"));
            VtexPage_admitOne.closeNewsLetter();
           VtexPage_babyCotton.SearchProduct("remera");
            VtexPage_Vitamin.cartCheckOut();
            VtexPage_babyCotton.deleteItemCart(VtexPage_babyCotton.emptyCartMsg,VtexPage_babyCotton.umarCartPgLogo);
           VtexPage_babyCotton.SearchProduct("remera");
            VtexPage_Vitamin.cartCheckOut();
            VtexPage_babyCotton.deleteItemCart(VtexPage_babyCotton.emptyCartMsg,VtexPage_babyCotton.umarCartPgLogo);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "search box link displayed and validate each of them")
    public void searchBoxItems() {

        try {
            visit(getProperty("url_vitamina"));

            //ogleSignIn.enterWithGoogle(getProperty("testQa"), getProperty("testPassQa"));
            VtexPage_Umbroar.getListInSearchBox(VtexPage_Umbroar.searchResultUmbroar, VtexPage_Umbroar.searchResultCountUmbroar);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "place order successfully.....")
    public void placeOrderSuccessfully() {


        try {
            visit(getProperty("url_vitamina"));
            VtexPage_admitOne.closeNewsLetter();
            VtexPage_babyCotton.registerCheck();
            VtexPage_babyCotton.MailinatorChecking();
            VtexPage_babyCotton.enterTokenAndPassword();
           VtexPage_babyCotton.SearchProduct("remera");
            VtexPage_Vitamin.cartCheckOut();
            VtexPage_babyCotton.cartPageDetailFill();
            VtexPage_babyCotton.finalBuyButton(VtexPage_babyCotton.finalComprarAhora);
            VtexPage_Vitamin.mercPagoEffectivo();
            VtexPage_babyCotton.pagarMercadoPago();
            VtexPage_babyCotton.MailinatorToForOrderConfirmation();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "create account and change password from my account page ")
    public void myAccChangePass() {

        try {

            visit(getProperty("url_vitamina"));
            VtexPage_admitOne.closeNewsLetter();
            VtexPage_babyCotton.registerCheck();
            VtexPage_babyCotton.MailinatorChecking();
            VtexPage_babyCotton.enterTokenAndPassword();
            VtexPage_babyCotton.myAccountDetailCheck();
            VtexPage_babyCotton.myAccountChangePassword();


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


}
