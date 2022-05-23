package ui_tests.vtex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import static utilities.ConfigReader.getProperty;

public class umaar extends Driver {
    public static Logger log = LogManager.getLogger(umaar.class);
    public String productName, productPrice;

//    @BeforeTest
//    public void RunSetup() {
//
//        try {
//            visit(getProperty("umaar_VTEX"));
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("failed due to :::" + e.getMessage());
//            Assert.fail(e.getMessage());
//        }


//    }

    @Test(description = "login flow")
    public void loginCheck() {


        try {
            visit(getProperty("umaar_VTEX"));
            googleSignIn.enterWithGoogle(getProperty("testQa"), getProperty("testPassQa"));
            VtexPage_admitOne.closeNewsLetter();
            VtexPage_babyCotton.registerCheck();
            VtexPage_babyCotton.MailinatorChecking();
            VtexPage_babyCotton.enterTokenAndPassword();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "delete the product from cart and add it again")
    public void deleteProductFrmCart() {


        try {
            visit(getProperty("umaar_VTEX"));
            googleSignIn.enterWithGoogle(getProperty("testQa"), getProperty("testPassQa"));
            VtexPage_admitOne.closeNewsLetter();
            VtexPage_admitOne.SearchProduct("tops");
            VtexPage_admitOne.cartCheckOut();
            VtexPage_babyCotton.deleteItemCart(VtexPage_babyCotton.emptyCartMsg,VtexPage_babyCotton.umarCartPgLogo);
            VtexPage_admitOne.SearchProduct("remera");
            VtexPage_admitOne.cartCheckOut();
            VtexPage_babyCotton.deleteItemCart(VtexPage_babyCotton.emptyCartMsg,VtexPage_babyCotton.umarCartPgLogo);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "login flow")
    public void placeOrderSuccessfully() {


        try {
            visit(getProperty("umaar_VTEX"));
            googleSignIn.enterWithGoogle(getProperty("testQa"), getProperty("testPassQa"));
            VtexPage_admitOne.closeNewsLetter();
            VtexPage_babyCotton.registerCheck();
            VtexPage_babyCotton.MailinatorChecking();
            VtexPage_babyCotton.enterTokenAndPassword();
            VtexPage_admitOne.SearchProduct("tops");
            VtexPage_admitOne.cartCheckOut();
            VtexPage_babyCotton.cartPageDetailFill();
            VtexPage_babyCotton.finalBuyButton(VtexPage_babyCotton.finalComprarAhora);
            VtexPage_babyCotton.pagarMercadoPago();
            VtexPage_babyCotton.MailinatorToForOrderConfirmation();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "search box link displayed and validate each of them")
    public void searchBoxItems() {


        try {
            visit(getProperty("umaar_VTEX"));
            googleSignIn.enterWithGoogle(getProperty("testQa"), getProperty("testPassQa"));
            VtexPage_admitOne.closeNewsLetter();
            VtexPage_admitOne.getListInSearchBox(VtexPage_admitOne.searchResultUmaar, VtexPage_admitOne.searchResultCountUmaar);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "create account and change password from my account page ")
    public void myAccChangePass() {

        try {

            visit(getProperty("umaar_VTEX"));
            googleSignIn.enterWithGoogle(getProperty("testQa"), getProperty("testPassQa"));
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
