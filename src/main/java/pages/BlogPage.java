package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static factory.DriverFactory.getChromeDriver;

public class BlogPage extends HomePage{

    private WebDriver driver = getChromeDriver();

    public void validateBlogUrl(){

        String blogUrl = driver.getCurrentUrl();
        Assert.assertEquals(blogUrl,"https://davorminchorov.com/blog", "Ups... Wrong Page...");
    }

}
