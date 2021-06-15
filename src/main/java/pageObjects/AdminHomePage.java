package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonFunctions;

public class AdminHomePage extends CommonFunctions {

    public WebDriver driver;

    public AdminHomePage(WebDriver driver2)
    {
        this.driver = driver2;
    }

    //change url to admin home page
    String urlHomePage = "http://3.13.126.58/AMS3.0/home";

    public void changeUrl()
    {
        driver.get(urlHomePage);
    }

    //locators

    @FindBy(xpath = "//h2[normalize-space(text())='Welcome to Invoice Manager!']")
    public WebElement welcomeText;


    @FindBy(xpath = "//a[@class='mm_products']")
    public WebElement productsFilterBtn;


    public void chooseMainCategory(String main)
    {
        WebElement filter = driver.findElement(By.xpath("//a[@class='mm_"+main+"']"));
        moveToElementAndClick(filter);

    }


    public void chooseSubCategory(String sub)
    {
        WebElement subFilter = driver.findElement(By.xpath("//a[text()='"+sub+"']"));
        scrollToElementAndClick(subFilter);

    }


}
