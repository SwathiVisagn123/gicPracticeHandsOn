package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

public class ListProductsPage extends CommonFunctions {
    public WebDriver driver;

    public ListProductsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[text()='Product successfully added']")
    public WebElement successAlert;

    String listPageUrl = "http://3.13.126.58/AMS3.0/products";

    public void validateListProductPage()
    {
        compareUrl(listPageUrl);
    }


    public  void validateSuccessAlert()
    {
        Assert.assertTrue(successAlert.isDisplayed());
    }






}
