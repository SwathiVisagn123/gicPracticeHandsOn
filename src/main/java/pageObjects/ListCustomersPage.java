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

    public void clickColumnName(String columnName) {
        WebElement columnValue = driver.findElement(By.xpath("//a[text()='" + columnName + "']"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(columnValue));
        scrollToElementAndClick(columnValue);
    }

    //few columns deselected

    public void validateColumnFilter(String columnName) {


        List<WebElement> columnValues = driver.findElements(By.xpath("//*[@id=\"fileData\"]/thead/tr"));
        System.out.println("The displayed columns are :");
        for (WebElement value : columnValues)
        {
            String valueName = value.getText();
            System.out.println(valueName);
            if (valueName.contains(columnName))
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


    //deselect none or select all
    public void clickAllInactiveColumns() throws InterruptedException {
        List<WebElement> element = driver.findElements(By.xpath("//li[@class='dt-button buttons-columnVisibility']"));
        for (WebElement value : element) {
            value.click();
            Thread.sleep(1000);
        }

    }


    public void validateColumnsDisplayed() {

        List<WebElement> columnValues = driver.findElements(By.xpath("//*[@id=\"fileData\"]/thead/tr"));
        //print results
        System.out.println("The displayed columns are :");
        for (WebElement columnName : columnValues) {
            String column = columnName.getText();
            System.out.println(column);
            //validate results


        }


    }

}