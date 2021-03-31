package Tests;

import org.testng.annotations.Test;
import pages.HomePage;

import static pages.HomePage.getHomePage;

public class BrokenLinksTests extends BaseSet {

    HomePage homepage = getHomePage();

    @Test
    public void testBrokenLinks() {
        homepage.brokenLinksCheck();
    }
}
