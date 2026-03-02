import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BrowserFactory {
    public static WebDriver startApplication(WebDriver driver,String browserName,String url){
        if(browserName.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browserName.equals("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browserName.equals("IE")){
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }else{
            System.out.println("We do not support this browser");
        }
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
    public static void quitBrowser(WebDriver driver){
        driver.quit();
    }
}