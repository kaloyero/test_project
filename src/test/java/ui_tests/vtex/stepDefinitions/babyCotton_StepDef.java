package ui_tests.vtex.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import utilities.Driver;

@RunWith(Cucumber.class)
public class babyCotton_StepDef extends Driver {


    @Then("searching the product {string} in search box and click on first result in baby cottons")
    public void searching_the_product_in_search_box_and_click_on_first_result_in_baby_cottons(String bbyctnPrct) {
        VtexPage_babyCotton.babySearchProduct(bbyctnPrct);
    }
    @Then("product has been checkOut for baby cottons")
    public void product_has_been_check_out_for_baby_cottons() {
        VtexPage_babyCotton.cartCheckOut();
    }

    @When("selecting effectivo option and clicking the final pay button")
    public void selecting_effectivo_option_and_clicking_the_final_pay_button() {
        VtexPage_babyCotton.paymentCashOption();
    }

}