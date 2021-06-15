package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

public class ClientPage extends CommonFunctions {

    public WebDriver driver;

    public ClientPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //validate client page
    String expectedClientUrl = "http://3.13.126.58/AMS3.0/clients";

    public void validateClientPage()
    {
        compareUrl(expectedClientUrl);
    }







}
