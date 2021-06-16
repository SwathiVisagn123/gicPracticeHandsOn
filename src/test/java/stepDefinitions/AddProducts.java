package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddProductPage;
import pageObjects.AdminHomePage;
import pageObjects.ListProductsPage;
import utils.CommonFunctions;

import java.io.IOException;

public class AddProducts extends CommonFunctions {


AdminHomePage adminHomePage = new AdminHomePage(driver);
AddProductPage addProductPage = new AddProductPage(driver);
ListProductsPage listProductsPage = new ListProductsPage(driver);


    @When("I select the main category {string}")
    public void i_select_the_main_category(String main) throws InterruptedException {

        adminHomePage.chooseMainCategory(main);
        Thread.sleep(2000);

    }


    @When("I select the sub filter option {string}")
    public void i_select_the_sub_filter_option(String sub) throws InterruptedException {

      adminHomePage.chooseSubCategory(sub);
      Thread.sleep(2000);

    }
    @Then("I should be re-directed to appropriate New Product page")
    public void i_should_be_re_directed_to_appropriate_new_product_page() {

        addProductPage.validateAddProductPage();


    }
    @When("I type product name {string}")
    public void i_type_product_name(String name) {

        addProductPage.typeName(name);


    }
    @When("I type product details {string}")
    public void i_type_product_details(String detailInfo) {


        addProductPage.typeDetails(detailInfo);


    }
    @When("I type product price {string}")
    public void i_type_product_price(String amount) throws InterruptedException {


        addProductPage.typePrice(amount);
        Thread.sleep(2000);



    }
    @When("I click Submit Button")
    public void i_click_submit_button() {


        addProductPage.clickSubmit();


    }


    //valid data
    @Then("I should be re-directed to appropriate List Products page with product added alert.")
    public void i_should_be_re_directed_to_appropriate_list_products_page_with_product_added_alert() throws InterruptedException {


        listProductsPage.validateListProductPage();
        listProductsPage.validateSuccessAlert();
        Thread.sleep(3000);

    }

    //invalid data
    @Then("I should get an invalid field error message and remain in the same add product page")
    public void i_should_get_an_invalid_field_error_message_and_remain_in_the_same_add_product_page() throws InterruptedException, IOException {

        takeScreenGrab("invalidProd.jpg");
        addProductPage.validateAddProductPage();
        Thread.sleep(2000);




    }



    //no data
    @Then("I should get an empty field error message and remain in the same add product page")
    public void i_should_get_an_empty_field_error_message_and_remain_in_the_same_add_product_page() throws InterruptedException {


        addProductPage.validateEmptyNameAlert();
        addProductPage.validateEmptyPriceAlert();
        addProductPage.validateAddProductPage();
        Thread.sleep(3000);


    }










}
