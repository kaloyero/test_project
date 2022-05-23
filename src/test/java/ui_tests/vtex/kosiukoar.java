package ui_tests.vtex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import static utilities.ConfigReader.getProperty;

public class kosiukoar extends Driver {
    public static Logger log = LogManager.getLogger(kosiukoar.class);
    public String productName, productPrice;


    @Test(description = "login flow")
    public void loginCheck() {


        try {
            visit(getProperty("kosiukoar_VTEX"));
            googleSignIn.enterWithGoogle(getProperty("testQa"), getProperty("testPassQa"));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "search box link displayed and validate each of them")
    public void searchBoxItems() {


        try {
            visit(getProperty("kosiukoar_VTEX"));
            googleSignIn.enterWithGoogle(getProperty("testQa"), getProperty("testPassQa"));
            VtexPage_admitOne.closeNewsLetter();
            VtexPage_admitOne.getListInSearchBox(VtexPage_admitOne.searchResultAdmitOne, VtexPage_admitOne.searchResultCountAdmitOne);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "delete the product from cart and add it again")
    public void deleteProductFrmCart() {

        try {
            visit(getProperty("kosiukoar_VTEX"));
            googleSignIn.enterWithGoogle(getProperty("testQa"), getProperty("testPassQa"));
//            VtexPage_admitOne.closeNewsLetter();
            VtexPage_kosiukoar.SearchProduct("remera");
            VtexPage_admitOne.cartCheckOut();
            VtexPage_babyCotton.deleteItemCart(VtexPage_babyCotton.emptyCartMsg,VtexPage_kosiukoar.kosiukoLogo);
            VtexPage_kosiukoar.SearchProduct("remera");
            VtexPage_admitOne.cartCheckOut();
            VtexPage_babyCotton.deleteItemCart(VtexPage_babyCotton.emptyCartMsg,VtexPage_kosiukoar.kosiukoLogo);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "create account and change password from my account page ")
    public void myAccChangePass() {

        try {

            visit(getProperty("kosiukoar_VTEX"));
            googleSignIn.enterWithGoogle(getProperty("testQa"), getProperty("testPassQa"));
//            VtexPage_admitOne.closeNewsLetter();
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

    @Test(description = "place order successfully.....")
    public void placeOrderSuccessfully() {


        try {
            visit(getProperty("kosiukoar_VTEX"));
            googleSignIn.enterWithGoogle(getProperty("testQa"), getProperty("testPassQa"));
//            VtexPage_admitOne.closeNewsLetter();
            VtexPage_babyCotton.registerCheck();
            VtexPage_babyCotton.MailinatorChecking();
            VtexPage_babyCotton.enterTokenAndPassword();
            VtexPage_kosiukoar.SearchProduct("remera");
            VtexPage_admitOne.cartCheckOut();
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


}
