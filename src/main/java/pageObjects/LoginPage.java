package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    //constructor method to pass the driver object for amm methods in this page
    public LoginPage (WebDriver driver)
    {
       this.driver = driver;
       PageFactory.initElements(driver,this);

    }

    //locators

    @FindBy(xpath = "//h1[text()='Invoice Manager']")
    public WebElement invoiceManagerText;

    @FindBy(id = "inputEmail")
    public WebElement emailField;


    @FindBy(id = "inputPassword")
    public WebElement passwordField;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;


    //actions on elements
    public void typeEmail(String email)
    {
        emailField.sendKeys(email);
    }

    public void typePassword(String password)
    {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton()
    {
        loginButton.click();
    }


}
