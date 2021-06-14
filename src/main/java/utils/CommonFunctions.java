package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonFunctions {

    public static WebDriver driver;
   String filePath = new File ("src/main/resources/testData/urlInfo.properties").getAbsolutePath();


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




}
