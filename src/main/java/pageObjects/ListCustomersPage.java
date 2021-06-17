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

        List<WebElement> columnValues = driver.findElements(By.xpath("//*[@id=\"fileData\"]/thead/tr"));
        System.out.println("The displayed columns are :");
        for (WebElement value : columnValues)
        {
            String valueName = value.getText();

            //validate results
            //Assert.assertEquals(valueName, columnName);

            //print filter results and valuations
            System.out.println(valueName);
            if (valueName.equals(columnName))
            {
                System.out.println("Unselected columns are present.Validation failed");
            }
            else System.out.println("Filter applied Successful");



        }


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
        ArrayList<String> list = new ArrayList<>();

        //print results
        System.out.println("The displayed columns are :");
        for (WebElement columnName : columnNames)
        {
            String column = columnName.getText();
            list.add(column);
            System.out.println(column);

        }
        //validate results
        //Assert.assertTrue(list.isEmpty());

    }


    //deselect none or select all
    public void clickAllInactiveColumns() throws InterruptedException
    {


        //columns filter selected
        List<WebElement> element = driver.findElements(By.xpath("//li[@class='dt-button buttons-columnVisibility']"));
        for (WebElement value : element)
        {
            value.click();
            Thread.sleep(1000);
        }




    }

public void validateColumnsDisplayedForAll()
{
    //collecting all column names before filter container
    List<WebElement> before = driver.findElements(By.xpath("//ul[@class='dt-button-collection dropdown-menu']"));
    ArrayList<String> listBefore = new ArrayList<>();
    for (WebElement columnName : before)
    {
        String column = columnName.getText();
        listBefore.add(column);
      }

    //column names after filter selection
    List<WebElement> after = driver.findElements(By.xpath("//*[@id=\"fileData\"]/thead/tr"));
    ArrayList<String> listAfter = new ArrayList<>();

    System.out.println("The displayed columns are :");
    for (WebElement columnName : after)
    {
        String column = columnName.getText();
        listAfter.add(column);
        System.out.println(column);

    }

    //validating results by comparing
    //Assert.assertEquals(listBefore,listAfter);

}



}


