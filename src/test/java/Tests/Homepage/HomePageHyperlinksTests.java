package Tests.Homepage;

import Tests.BaseSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;

import static factory.DriverFactory.getChromeDriver;
import static pages.HomePage.getHomePage;

public class HomePageHyperlinksTests extends BaseSet {

    private WebDriver driver = getChromeDriver();

    HomePage homepage = getHomePage();

    /**
     * Test ID: n13, n14
     */
    @Test
    public void validate_quantox_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.linkText("Quantox Technology")));
        homepage.getHyperlinkColor("#9ae6b4")
                .clickAndCheckLink("https://quantox.com/");
    }

    /**
     * Test ID: n15, n16
     */
    @Test
    public void validate_adeva_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.linkText("Adeva, an exclusive remote developers' network")));
        homepage.getHyperlinkColor("#9ae6b4")
                .clickAndCheckLink("adevait.com");
    }

    /**
     * Test ID: n17, n18
     */
    @Test
    public void validate_tabellarius_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.linkText("Tabellarius")));
        homepage.getHyperlinkColor("#9ae6b4")
                .clickAndCheckLink("tabellarius.mk");
    }

    /**
     * Test ID: n19, n20
     */
    @Test
    public void validate_intertec_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.linkText("Intertec")));
        homepage.getHyperlinkColor("#9ae6b4")
                .clickAndCheckLink("www.intertec.io");
    }

    /**
     * Test ID: n21, n22
     */
    @Test
    public void validate_adeva_bootcamp_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.linkText("Adeva's Female Bootcamp 2018")));
        homepage.getHyperlinkColor("#9ae6b4")
                .clickAndCheckLink("femalebootcamp.adevait.com");
    }

    /**
     * Test ID: n23, n24
     */
    @Test
    public void validate_check_here_hyperlink_after_adeva_bootcamp() {
        homepage.findHyperlink(driver.findElement(By.linkText("here")));
        homepage.getHyperlinkColor("#9ae6b4")
                .clickAndCheckLink("blog.usejournal.com/the-tech-bootcamp-experience-ff53367b79a7");
    }

    /**
     * Test ID: n25
     */
    @Test
    public void validate_linkedIn_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.xpath("/html/body/div/footer/a[1]")));
        homepage.clickAndCheckLink("https://www.linkedin.com/in/davorminchorov/");
    }

    /**
     * Test ID: n26
     */
    @Test
    public void validate_gitHub_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.xpath("/html/body/div/footer/a[2]")));
        homepage.clickAndCheckLink("https://github.com/davorminchorov");
    }

    /**
     * Test ID: n27
     */
    @Test
    public void validate_twitter_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.xpath("/html/body/div/footer/a[3]")));
        homepage.clickAndCheckLink("https://twitter.com/davorminchorov");
    }
}