package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    /**
     * Prevent instantiation
     */
    private DriverFactory() {
    }

    /**
     * This method prevents NullPointerException
     * It returns the ChromeDriver
     *
     * @return WebDriver
     */
    public static WebDriver getChromeDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

            driver = new ChromeDriver();
        }

        return driver;
    }

}


