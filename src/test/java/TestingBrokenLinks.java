
import Tests.BaseSet;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestingBrokenLinks extends BaseSet {
    HomePage homepage = new HomePage();

    //Testing app broken links
    @Test
    public void testBrokenLinks() {
        homepage.brokenLinksCheck();
    }
}
