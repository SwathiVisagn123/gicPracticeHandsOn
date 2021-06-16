package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ListProductsPage;
import utils.CommonFunctions;

import java.io.IOException;

public class RetrieveAddedProduct extends CommonFunctions {

    ListProductsPage listProductsPage = new ListProductsPage(driver);


    @When("I type product name {string} in the search field and click Enter")
    public void i_type_product_name_in_the_search_field_and_click_enter(String name) throws InterruptedException {
        listProductsPage.typeInSearchBox(name);
    }

    @Then("I should be able to retrieve the added product {string} successfully")
    public void i_should_be_able_to_retrieve_the_added_product_successfully(String name) throws InterruptedException, IOException {
        Thread.sleep(2000);
        listProductsPage.printAndValidateSearchResult(name);

    }



}
