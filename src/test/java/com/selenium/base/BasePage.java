package com.selenium.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.selenium.utils.BrowserFactory;
import com.selenium.utils.ConfigDataProvider;

public class BasePage {
    WebDriver driver;
    ConfigDataProvider config = new ConfigDataProvider();

    @BeforeTest
    public void setup(){
        driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
        if(driver==null){
            throw new RuntimeException("Driver is not initialized. Check the browser name and URL in config file.");
        }
    }

    @AfterTest
    public void tearDown(){
        if(driver!=null){
            BrowserFactory.quitBrowser(driver);
        }
    }
}
