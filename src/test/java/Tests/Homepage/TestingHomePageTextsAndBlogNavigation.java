package Tests.Homepage;

import Tests.BaseSet;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestingHomePageTextsAndBlogNavigation extends BaseSet {

    HomePage homepage = new HomePage();

    /*Test ID: n3
    Clicking the blog button on homescreen page and validating
    that we are on the expected page.
     */
    @Test
    public void click_on_blog_and_validate_Url() {

        homepage.findBlog();
        homepage.clickBlog().validateBlogUrl();
    }

    /*
    Test ID: n2
    Finding all the elements on the screen and validating them
     */
    @Test
    public void validate_HomeScreen() {

        homepage.validateScreen();
    }

    /*
    Test ID: n4
    Validating About Me text
     */
    @Test
    public void check_about_me_text() {

        homepage.checkAboutMe();
    }

    /*
    Test ID: n5
    Validating Technology Stack text
    n4 and n5 can be all together with validatescreen method.
     */
    @Test
    public void check_TechnologyStack_text() {

        homepage.checkTechnologyStackText();
    }
}