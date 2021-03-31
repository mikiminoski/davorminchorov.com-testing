package Tests.Homepage;

import Tests.BaseSet;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.HomePage;

import static pages.BlogPage.getBlogPage;
import static pages.HomePage.getHomePage;

public class HomePageTextsAndBlogNavigationTests extends BaseSet {

    HomePage homepage = getHomePage();
    BlogPage blogpage = getBlogPage();

    /**
     * Test ID: n3
     */
    @Test
    public void click_on_blog_and_validate_url() {
        homepage.findBlog()
                .clickBlog();

        blogpage.validateBlogUrl();
    }

    /**
     * Test ID: n2
     */
    @Test
    public void validate_home_screen() {
        homepage.validateScreen();
    }

    /**
     * Test ID: n4
     */
    @Test
    public void check_about_me_text() {
        homepage.checkAboutMe();
    }

    /**
     * Test ID: n5
     */
    @Test
    public void check_technology_stack_text() {
        homepage.checkTechnologyStackText();
    }
}