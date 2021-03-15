package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static factory.DriverFactory.getChromeDriver;


public class BaseSet {

    protected WebDriver driver;
    protected String url;
    protected WebDriverWait wait;

    public BaseSet() {
    }

    @BeforeSuite
    public void setUp() {
        driver = getChromeDriver();
        System.out.println(driver);
        url = "http://davorminchorov.com/?ref=MikiAutomation";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @BeforeClass
    public void setUp2() {
        driver = getChromeDriver();
        System.out.println(driver);
        url = "http://davorminchorov.com/?ref=MikiAutomation";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @BeforeMethod
    public void goToHomePage() {
        driver.get(url);
    }

    @AfterSuite
    public void quit() {
        driver.quit();
    }
}
