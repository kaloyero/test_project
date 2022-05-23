package ui_tests.vtex;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import static utilities.ConfigReader.getProperty;

public class Mimoar extends Driver {
    public static Logger log = LogManager.getLogger(umbroar.class);


    @Test(description = "delete the product from cart and add it again")
    public void deleteProductFrmCart() {


        try {
            // launching the url
            visit(getProperty("url_mimo"));

            // closing the pop up
            VtexPage_admitOne.PopUpGracias(VtexPage_admitOne.buttonNoGracias);

            // closing the newsLetter
            VtexPage_admitOne.closeNewsLetter();

            //searching the product
            VtexPage_Minoar.SearchProduct("remera");

            //check out the product
            VtexPage_Minoar.cartCheckOut();

            // deleted the product and navigated to home page
            VtexPage_babyCotton.deleteItemCart(VtexPage_Minoar.emptyCartMessage, VtexPage_Minoar.logoClick);

            //searching the product
            VtexPage_Minoar.SearchProduct("remera");

            //check out the product
            VtexPage_Minoar.cartCheckOut();

            // deleted the product and navigated to home page
            VtexPage_babyCotton.deleteItemCart(VtexPage_Minoar.emptyCartMessage, VtexPage_Minoar.logoClick);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "login flow")
    public void placeOrderSuccessfully() {


        try {
            // launching the url
            visit(getProperty("url_mimo"));

            // closing the pop up
            VtexPage_admitOne.PopUpGracias(VtexPage_admitOne.buttonNoGracias);

            // closing the newsLetter
            VtexPage_admitOne.closeNewsLetter();

            //signup the customer
            VtexPage_babyCotton.registerCheck();

            //getting code from mail
            VtexPage_babyCotton.MailinatorChecking();

            //entering the password
            VtexPage_babyCotton.enterTokenAndPassword();

            //searching the product
            VtexPage_Minoar.SearchProduct("remera");

            //check out the product
            VtexPage_Minoar.cartCheckOut();

            //filling the shipping address detials
            VtexPage_babyCotton.cartPageDetailFill();

            //select mercado pago options
            VtexPage_Minoar.selectMercodoPagoOpt();

            // clicking on the final comparar button
            VtexPage_babyCotton.finalBuyButton(VtexPage_Minoar.finalComprar);

            // selecting effectivo option
            VtexPage_Minoar.mercPagoEffectivo();

            //selecting the final pay button
            VtexPage_babyCotton.pagarMercadoPago();

            //confirmation with mail
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
            visit(getProperty("url_mimo"));
            VtexPage_admitOne.PopUpGracias(VtexPage_admitOne.buttonNoGracias);
            VtexPage_admitOne.closeNewsLetter();
            VtexPage_Umbroar.getListInSearchBox(VtexPage_Umbroar.searchResultUmbroar, VtexPage_Umbroar.searchResultCountUmbroar);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(description = "create account and change password from my account page ")
    public void myAccChangePass() {

        try {

            visit(getProperty("url_mimo"));
            VtexPage_admitOne.PopUpGracias(VtexPage_admitOne.buttonNoGracias);
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