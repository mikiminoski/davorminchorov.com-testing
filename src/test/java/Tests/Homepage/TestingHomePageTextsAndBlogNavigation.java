package Tests.Homepage;

import Tests.BaseSet;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestingHomePageTextsAndBlogNavigation extends BaseSet {

    HomePage homepage = new HomePage();

    /**
     * Test ID: n3
     */
    @Test
    public void click_on_blog_and_validate_url() {
        homepage.findBlog();
        homepage.clickBlog().validateBlogUrl();
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