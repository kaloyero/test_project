package ui_tests.vtex.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import utilities.Driver;

@RunWith(Cucumber.class)
public class filaar_StepDef extends Driver {


    @Then("searching the product {string} in search box and click on first result in filaar")
    public void searching_the_product_in_search_box_and_click_on_first_result_in_filaar(String bbyctnPrct) {
        VtexPage_babyCotton.SearchProduct(bbyctnPrct);
    }
    @Then("product has been checkOut for filaar")
    public void product_has_been_check_out_for_filaar() {
        VtexPage_Fila.cartCheckOut();
    }

    @Then("user delete the product and navigate to fila home page")
    public void user_delete_the_product_and_navigate_to_fila_home_page() {
        VtexPage_babyCotton.deleteItemCart(VtexPage_babyCotton.emptyCartMsg,VtexPage_Fila.filaLogo);
    }

    @When("clicking on comprar button")
    public void clicking_on_comprar_button() {
        VtexPage_babyCotton.finalBuyButton(VtexPage_babyCotton.finalComprarAhora);
        VtexPage_Minoar.selectMercodoPagoOpt();
    }

}