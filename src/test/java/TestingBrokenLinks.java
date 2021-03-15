
import Tests.BaseSet;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestingBrokenLinks extends BaseSet {

    HomePage homepage = new HomePage();

    @Test
    public void testBrokenLinks() {
        homepage.brokenLinksCheck();
    }
}
