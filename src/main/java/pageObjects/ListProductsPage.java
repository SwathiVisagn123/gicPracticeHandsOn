package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

import java.util.List;

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


    @FindBy(id = "search_table")
    public WebElement searchBox;


    @FindBy(xpath = "//*[@id=\"fileData\"]/tbody")
    public List<WebElement> resultsTable;




    public void typeInSearchBox(String name) throws InterruptedException {

        scrollUntilVisible(searchBox);
        Thread.sleep(2000);
        searchBox.sendKeys(name);
        //click enter after typing search term
        searchBox.sendKeys(Keys.ENTER);
    }



   public void validateListProductPage()
    {
        compareUrl(listPageUrl);
    }


    public  void validateSuccessAlert()
    {
        Assert.assertTrue(successAlert.isDisplayed());
    }




    public void printAndValidateSearchResult(String name)
    {
        explicitWait(driver.findElement(By.xpath("//*[@id=\"fileData\"]/tbody")));
        System.out.println("The retrieved results are");


        for(WebElement retrievedResults : resultsTable)
        {
            String productResultName = retrievedResults.getText();
            System.out.println(productResultName);
            Assert.assertTrue(productResultName.contains(name));
        }

        System.out.println("The added product "+name+" is retrieved successfully in List Products Page");
    }


}
