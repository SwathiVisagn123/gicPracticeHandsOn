package pageObjects;

import org.openqa.selenium.WebDriver;

public class AdminHomePage {

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




}
