package com.selenium.base;

import java.awt.Desktop;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.selenium.utils.BrowserFactory;
import com.selenium.utils.ConfigDataProvider;
import com.selenium.utils.ExtentManager;

public class BaseTest {
    WebDriver driver;
    ConfigDataProvider config = new ConfigDataProvider();
    protected static ExtentReports extent;

    @BeforeTest
    public void setup(){
        driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
        if(driver==null){
            throw new RuntimeException("Driver is not initialized. Check the browser name and URL in config file.");
        }
        extent = ExtentManager.getInstance();
    }

    @AfterTest
    public void tearDown(){
        if(driver!=null){
            BrowserFactory.quitBrowser(driver);
        }
        extent.flush();
        try {
              String reportPath = System.getProperty("user.dir")+"/resources/extent-report.html";
              Desktop.getDesktop().browse(new File(reportPath).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
