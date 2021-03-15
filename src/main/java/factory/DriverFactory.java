package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory (){
    //prevent instantiation
    }

    public static WebDriver getChromeDriver(){

        if (driver == null){
            System.setProperty("webdriver.chrome.driver","/Users/Administrator/Desktop/QA/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

}


