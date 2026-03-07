package com.selenium.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
    public static String getScreenShot(WebDriver driver, String name){
        String path = System.getProperty("user.dir")+"/screenshots/"+name+".png";

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(src,new File(path));
        }catch(Exception e){
            e.printStackTrace();
        }
         return path;
    }
}
