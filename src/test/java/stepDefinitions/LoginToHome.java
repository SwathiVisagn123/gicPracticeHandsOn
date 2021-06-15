package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AdminHomePage;
import pageObjects.ClientPage;
import pageObjects.LoginPage;
import utils.CommonFunctions;

import java.io.IOException;

public class LoginToHome extends CommonFunctions {


    LoginPage loginPage = new LoginPage(driver);
    ClientPage clientPage = new ClientPage(driver);
    AdminHomePage adminHomePage = new AdminHomePage(driver);
    CommonFunctions commonFunctions = new CommonFunctions();

    @Given("I'm on Invoice Manager Login Page {string}")
    public void i_m_on_invoice_manager_login_page(String key) throws IOException {

    String url = passUrlPath(key);
    driver.get(url);
    loginPage.validateLoginPage();


    }

    @When("I enter the valid email {string} in email address field")
    public void i_enter_the_valid_email_in_email_address_field(String email) throws InterruptedException {

       loginPage.typeEmail(email);



    }
    @When("I enter the valid password {string} in password field")
    public void i_enter_the_valid_password_in_password_field(String password) {
        loginPage.typePassword(password);

    }
    @When("I click Login Button")
    public void i_click_login_button() {

        loginPage.clickLoginButton();
    }
    @Then("I should be re-directed to Client's Home Page")
    public void i_should_be_re_directed_to_client_s_home_page() throws InterruptedException {


        clientPage.validateClientPage();
        Thread.sleep(2000);

    }
    @When("I change the url end to home")
    public void i_change_the_url_end_to_home() throws InterruptedException {

        adminHomePage.changeUrl();
        Thread.sleep(2000);


    }
    @Then("I should be re-directed to Admin Home Page")
    public void i_should_be_re_directed_to_admin_home_page() {



    }


}
