package com.selenium.utils;

public class ScreenshotUtils {
    public static String getScreenShot(WebDriver driver, String name){
        String path = System.getProperty("user.dir")+"/screenshots/"+name+".png";

        File src = ((TakeScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(src,new File(path));
        }catch(Exception e){
            e.printStackTrace();
    }
    return path;
}
