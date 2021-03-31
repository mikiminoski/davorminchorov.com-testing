package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static factory.DriverFactory.getChromeDriver;

public class BlogPage {

    WebDriver driver = getChromeDriver();

    private BlogPage(){
    }

    public static BlogPage getBlogPage(){
        return new BlogPage();
    }

    /**
     * Validates the blog URL
     *
     * @return void
     */
    public void validateBlogUrl() {
        String blogUrl = driver.getCurrentUrl();

        Assert.assertEquals(blogUrl, "https://davorminchorov.com/blog", "Ups... Wrong Page...");
    }
}