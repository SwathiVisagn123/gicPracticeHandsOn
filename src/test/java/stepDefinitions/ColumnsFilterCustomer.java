package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ListCustomersPage;
import utils.CommonFunctions;

public class ColumnsFilterCustomer extends CommonFunctions {

    ListCustomersPage listCustomersPage = new ListCustomersPage(driver);

    @Then("I should be re-directed to appropriate List Customers Page")
    public void i_should_be_re_directed_to_appropriate_list_customers_page() throws InterruptedException {

        listCustomersPage.validateCustomerPage();
        Thread.sleep(2000);


    }
    @When("I click on the columns button {string} in the page")
    public void i_click_on_the_columns_button_in_the_page(String Columns) throws InterruptedException {

       listCustomersPage.selectChoiceButton(Columns);
       Thread.sleep(2000);

    }

    //deselect few

    @When("I de-select the column name {string}")
    public void i_de_select_the_column_name(String columnName) throws InterruptedException {


        listCustomersPage.clickColumnName(columnName);
        Thread.sleep(1000);



    }
    @Then("I should not retrieve the de-selected columns {string} as the filter result")
    public void i_should_not_retrieve_the_de_selected_columns_as_the_filter_result(String columnName) {

        listCustomersPage.validateColumnsDisplayForFew(columnName);

    }



    //deselect all

    @When("I de-select all the active columns")
    public void i_de_select_all_the_active_columns() throws InterruptedException {

        listCustomersPage.clickAllActiveColumns();

    }
    @Then("I should not retrieve any filter results")
    public void i_should_not_retrieve_any_filter_results() {

     listCustomersPage.validateColumnsDisplayedForNone();

    }

    //deselect none or select all - all columns should be displayed


    @When("I select the default inactive columns")
    public void i_select_the_default_inactive_columns() throws InterruptedException {

        listCustomersPage.clickAllInactiveColumns();

    }
    @Then("I should retrieve all the columns in filter result")
    public void i_should_retrieve_all_the_columns_in_filter_result() {


        listCustomersPage.validateColumnsDisplayedForAll();
    }




}