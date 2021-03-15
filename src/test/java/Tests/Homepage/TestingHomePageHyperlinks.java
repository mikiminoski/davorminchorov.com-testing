package Tests.Homepage;

import Tests.BaseSet;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestingHomePageHyperlinks extends BaseSet {

    HomePage homepage = new HomePage();

    @Test
    public void validate_quantox_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.linkText("Quantox Technology")));
        homepage.getHyperlinkColor("#9ae6b4");
        homepage.clickAndCheckLink("quantox.com");
    }

    @Test
    public void validate_adeva_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.linkText("Adeva, an exclusive remote developers' network")));
        homepage.getHyperlinkColor("#9ae6b4");
        homepage.clickAndCheckLink("adevait.com");
    }

    @Test
    public void validate_tabellarius_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.linkText("Tabellarius")));
        homepage.getHyperlinkColor("#9ae6b4");
        homepage.clickAndCheckLink("tabellarius.mk");
    }

    @Test
    public void validate_intertec_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.linkText("Intertec")));
        homepage.getHyperlinkColor("#9ae6b4");
        homepage.clickAndCheckLink("www.intertec.io");
    }

    @Test
    public void validate_adeva_bootcamp_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.linkText("Adeva's Female Bootcamp 2018")));
        homepage.getHyperlinkColor("#9ae6b4");
        homepage.clickAndCheckLink("femalebootcamp.adevait.com");
    }

    @Test
    public void validate_check_here_hyperlink_after_adeva_bootcamp() {
        homepage.findHyperlink(driver.findElement(By.linkText("here")));
        homepage.getHyperlinkColor("#9ae6b4");
        homepage.clickAndCheckLink("blog.usejournal.com/the-tech-bootcamp-experience-ff53367b79a7");
    }

    @Test
    public void validate_linkedIn_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.xpath("/html/body/div/footer/a[1]")));
        homepage.clickAndCheckLink("www.linkedin.com/in/davorminchorov");
    }

    @Test
    public void validate_gitHub_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.xpath("/html/body/div/footer/a[2]")));
        homepage.clickAndCheckLink("github.com/davorminchorov");
    }

    @Test
    public void validate_twitter_hyperlink() {
        homepage.findHyperlink(driver.findElement(By.xpath("/html/body/div/footer/a[3]")));
        homepage.clickAndCheckLink("twitter.com/davorminchorov");
    }
}