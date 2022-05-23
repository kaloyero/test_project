package ui_tests.vtex.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import utilities.Driver;

import static utilities.ConfigReader.getProperty;

@RunWith(Cucumber.class)
public class admitOne_StepDef extends Driver {

    @Given("searching the product {string} in search box and click on first result in admitOne")
    public void searching_the_product_in_search_box_and_click_on_first_result_in_admit_one(String product) {
        VtexPage_admitOne.SearchProduct(product);
    }
    @Given("product has been checkOut for admitOne")
    public void product_has_been_check_out_for_admit_one() {
        VtexPage_admitOne.cartCheckOut();
    }


}