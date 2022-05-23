package ui_tests.vtex.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import utilities.Driver;

import static utilities.ConfigReader.getProperty;

@RunWith(Cucumber.class)
public class mimo_StepDef extends Driver {

    @Given("User launch the URL {string} of the brand")
    public void user_launch_the_url_of_the_brand(String url) {

        visit(getProperty(url));
    }

    @Given("close the popUp and news letter")
    public void close_the_pop_up_and_news_letter() {
        VtexPage_admitOne.PopUpGracias(VtexPage_admitOne.buttonNoGracias);
        VtexPage_admitOne.closeNewsLetter();
    }

    @Given("searching the product {string} in search box and click on first result")
    public void searching_the_product_in_search_box_and_click_on_first_result(String prdct) {
        VtexPage_Minoar.SearchProduct(prdct);
    }

    @Given("product has been checkOut")
    public void product_has_been_check_out() {
        VtexPage_Minoar.cartCheckOut();
    }

    @Then("user delete the product and navigate to home page")
    public void user_delete_the_product_and_navigate_to_home_page() {
        VtexPage_babyCotton.deleteItemCart(VtexPage_Minoar.emptyCartMessage, VtexPage_Minoar.logoClick);
    }


    @Given("sign up new customer")
    public void sign_up_new_customer() {
        VtexPage_babyCotton.registerCheck();
    }

    @Given("getting code from mail")
    public void getting_code_from_mail() {
        VtexPage_babyCotton.MailinatorChecking();
    }

    @Given("entering the password")
    public void entering_the_password() {
        VtexPage_babyCotton.enterTokenAndPassword();
    }

    @When("filling the shipping address and cart page details")
    public void filling_the_shipping_address_and_cart_page_details() {
        VtexPage_babyCotton.cartPageDetailFill();
    }

    @When("select mercado pago options  and clicking on comprar button")
    public void select_mercado_pago_options_and_clicking_on_comprar_button() {
        VtexPage_Minoar.selectMercodoPagoOpt();
        VtexPage_babyCotton.finalBuyButton(VtexPage_Minoar.finalComprar);
    }

    @When("selecting effectivo option")
    public void selecting_effectivo_option() {
        VtexPage_Minoar.mercPagoEffectivo();
    }

    @When("selecting the final pay button")
    public void selecting_the_final_pay_button() {
        VtexPage_babyCotton.pagarMercadoPago();
    }

    @Then("confirmation with mail")
    public void confirmation_with_mail() {
        VtexPage_babyCotton.MailinatorToForOrderConfirmation();
    }

    @Then("getting the list of item displayed in the search list and navigating each page")
    public void getting_the_list_of_item_displayed_in_the_search_list_and_navigating_each_page() {
        VtexPage_Umbroar.getListInSearchBox(VtexPage_Umbroar.searchResultUmbroar, VtexPage_Umbroar.searchResultCountUmbroar);

    }

    @When("checking the account detail page")
    public void checking_the_account_detail_page() {
        VtexPage_babyCotton.myAccountDetailCheck();
    }

    @Then("changing the password")
    public void changing_the_password() {
        VtexPage_babyCotton.myAccountChangePassword();
    }


}