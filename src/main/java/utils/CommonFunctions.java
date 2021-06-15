package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonFunctions {

    public static WebDriver driver;
   String filePath = new File ("src/main/resources/testData/urlInfo.properties").getAbsolutePath();
   String errorFilePath = new File("src/main/resources/errorShots").getAbsolutePath();


    public void openBrowser()
    {
        //sets up the chromedriver
    WebDriverManager.chromedriver().setup();
        //open chrome browser
    driver = new ChromeDriver();

    }

    public void closeBrowser()
    {
        driver.quit();
    }

    public String passUrlPath(String key) throws IOException {
        FileInputStream fileInputStream= new FileInputStream(filePath);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String value = properties.getProperty(key);
        return value;
    }


    public void takeScreenGrab(String imageName) throws IOException {

        TakesScreenshot takesScreenshot = ((TakesScreenshot)driver);
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File decFile = new File(errorFilePath+"/"+imageName);
        FileUtils.copyFile(srcFile,decFile);

    }


    public void compareUrl(String expected)
    {
       String actual = driver.getCurrentUrl();
       Assert.assertEquals(actual,expected);
    }

    public void moveToElementAndClick(WebElement element)
    {
        Actions move = new Actions(driver);
        move.moveToElement(element).click(element).build().perform();
    }

    public void scrollToElementAndClick(WebElement element)
    {
        JavascriptExecutor js  = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
    }




}
