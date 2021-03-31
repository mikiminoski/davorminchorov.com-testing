package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static factory.DriverFactory.getChromeDriver;

public class BaseSet {

    WebDriver driver;
    String url = "http://davorminchorov.com/?ref=MikiAutomation";

    /**
     * Setting before suite and getting the ChromeDriver
     *
     * @return void
     */
    @BeforeSuite
    public void setUp() {
        driver = getChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * When all the classes are run, we set up the ChromeDriver with before class method
     *
     * @return void
     */
    @BeforeClass
    public void setUp2() {
        driver = getChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Getting the homepage
     *
     * @return void
     */
    @BeforeMethod
    public void goToHomePage() {
        driver.get(url);
    }

    /**
     * Closing the browser
     *
     * @return void
     */
    @AfterSuite
    public void quit() {
        driver.quit();
    }
}