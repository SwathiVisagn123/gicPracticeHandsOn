package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCustomersPage extends CommonFunctions {

    public WebDriver driver;


    public ListCustomersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String customerPageUrl = "http://3.13.126.58/AMS3.0/customers";

    public void validateCustomerPage() {
        compareUrl(customerPageUrl);
    }

    public void selectChoiceButton(String choice) {
        WebElement Button = driver.findElement(By.xpath("//span[text()='" + choice + "']"));
        explicitWait(Button);
        moveToElementAndClick(Button);
    }

    //few columns deselected



    public void clickColumnName(String columnName) {

        WebElement columnValue = driver.findElement(By.xpath("//a[text()='" + columnName + "']"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(columnValue));
        scrollToElementAndClick(columnValue);

    }




    public void validateColumnsDisplayForFew(String columnName) {

       //element that has column names
        List<WebElement> columnValues = driver.findElements(By.xpath("//*[@id=\"fileData\"]/thead/tr"));

        //print filter results
        System.out.println("The displayed columns are :");

        for (WebElement value : columnValues)
        {
            String valueName = value.getText();

            System.out.println(valueName);
            if (valueName.equals(columnName))
            {
                System.out.println("Unselected columns are present.Validation failed");
            }
            else System.out.println("Filter applied Successful");

        }

        //Validating the element that has column names,do not have deselected column
        //I am finding elements that has the deselected column name and storing the results in a list.
        //List should be empty if element is not present
        //I am using list to store the result is null because otherwise the element is not present in the DOM.


        List<WebElement> deselected = driver.findElements(By.xpath("//th[text()='"+columnName+"']"));
        Assert.assertTrue(deselected.isEmpty());

    }


    //deselect all columns
    public void clickAllActiveColumns() throws InterruptedException {
        List<WebElement> element = driver.findElements(By.xpath("//li[@class='dt-button buttons-columnVisibility active']"));
        for (WebElement value : element) {
            value.click();
            Thread.sleep(1000);
        }
    }

    public void validateColumnsDisplayedForNone() {

        List<WebElement> columnNames = driver.findElements(By.xpath("//*[@id=\"fileData\"]/thead/tr"));


        //print results
        System.out.println("The displayed columns are :");
        for (WebElement columnName : columnNames)
        {
            String column = columnName.getText();

            System.out.println(column);

        }
        //Validating the element that has column names,do not have deselected column
        //I am finding elements that has the deselected column name and storing the results in a list.
        //List should be empty if element is not present
        //I am using list to store the result is null because otherwise the element is not present in the DOM.
        List<WebElement> element = driver.findElements(By.xpath("//li[@class='dt-button buttons-columnVisibility active']"));
        Assert.assertTrue(element.isEmpty());

    }


    //deselect none or select all
    public void clickAllInactiveColumns() throws InterruptedException
    {


        //columns filter selected (selecting the two default hidden columns to display all columns)
        List<WebElement> element = driver.findElements(By.xpath("//li[@class='dt-button buttons-columnVisibility']"));
        for (WebElement value : element)
        {
            value.click();
            Thread.sleep(1000);

        }




    }

public void validateColumnsDisplayedForAll()
{


  //column names after filter selection
  List<WebElement> after = driver.findElements(By.xpath("//*[@id=\"fileData\"]/thead/tr"));


   System.out.println("The displayed columns are :");
  for (WebElement columnName : after)
   {
       String column = columnName.getText();
      System.out.println(column);

}

   //the columns after selected will have the class name mentioning active, so finding if elements with below class name exists.
    //it must be null as all the columns are selected and displayed.
    List<WebElement> element = driver.findElements(By.xpath("//li[@class='dt-button buttons-columnVisibility']"));
    Assert.assertTrue(element.isEmpty());





}



}


