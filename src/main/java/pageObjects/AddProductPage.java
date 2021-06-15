package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

public class AddProductPage extends CommonFunctions {

    public WebDriver driver;

    public AddProductPage(WebDriver driver)
    {
       this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "name")
    public WebElement nameField;

    @FindBy(id = "details")
    public WebElement details;

    @FindBy(id = "price")
    public WebElement priceField;


    @FindBy(name = "submit")
    public WebElement submitButton;

    @FindBy(xpath = "//p[text()='The Name field is required.']")
    public WebElement emptyNameAlert;

    @FindBy(xpath = "//p[text()='The Price field is required.']")
    public WebElement emptyPriceAlert;

    String addProductPageUrl = "http://3.13.126.58/AMS3.0/products/add";


    public void typeName(String name)
    {
        nameField.sendKeys(name);
    }
    public void  typeDetails(String detailInfo)
    {
        details.sendKeys(detailInfo);
    }

    public void typePrice(String amount)
    {
        priceField.sendKeys(amount);
    }


    public void clickSubmit()
    {
        submitButton.click();
    }

     public void validateAddProductPage()
    {
        compareUrl(addProductPageUrl);
    }

public void validateEmptyNameAlert()
{
    Assert.assertTrue(emptyNameAlert.isDisplayed());
}


public void  validateEmptyPriceAlert()
{
    Assert.assertTrue(emptyPriceAlert.isDisplayed());
}



}
