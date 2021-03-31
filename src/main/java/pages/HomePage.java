package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static factory.DriverFactory.getChromeDriver;

public class HomePage {

    private WebDriver driver = getChromeDriver();
    private String url;
    HttpURLConnection huc;
    private WebElement find;
    private String linkText;

    Actions actions = new Actions(driver);

    private HomePage() {
    }

    public static HomePage getHomePage() {
        return new HomePage();
    }

    private WebElement locateAboutMe() {
        return driver.findElement(By.xpath("/html/body/div/main/div/div/div[2]/div[1]"));
    }

    private WebElement locateTechStack() {
        return driver.findElement(By.xpath("/html/body/div/main/div/div/div[2]/div[2]"));
    }

    private WebElement locateContactForm() {
        return driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form"));
    }

    private WebElement locateBlogButton() {
        return driver.findElement(By.xpath("/html/body/div/nav/a[2]"));
    }

    private WebElement locateUnsuccessfullySentMessageAlert() {
        return driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/div[1]"));
    }

    private WebElement locateNameFieldIsRequiredMessageAlert() {
        return driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[1]/span[2]"));
    }

    private WebElement locateEmailFieldIsRequiredMessageAlert() {
        return driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[2]/span[2]"));
    }

    private WebElement locateMessageFieldIsRequiredMessageAlert() {
        return driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[3]/span[2]"));
    }

    /**
     * Finds the blog link on the page, and asserts if the blog button is displayed.
     *
     * @return WebElement
     */
    public HomePage findBlog() {
        locateBlogButton();
        Assert.assertTrue(locateBlogButton().isDisplayed());

        return this;
    }

    /**
     * Clicks on the blog link and goes to the blog page.
     *
     * @return BlogPage
     */
    public void clickBlog() {
        locateBlogButton().click();
    }

    /**
     * Validating whole homepage screen and all elements that should be displayed
     *
     * @return void
     */
    public void validateScreen() {
        locateAboutMe();
        locateTechStack();
        locateContactForm();
        locateBlogButton();
        String blogButtonText = locateBlogButton().getText();

        WebElement davorMinchorov = driver.findElement(By.xpath("/html/body/div/nav/a[1]"));
        String davorMinchorovText = davorMinchorov.getText();

        WebElement picture = driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/div/img"));
        WebElement linkedInLogo = driver.findElement(By.linkText("Linkedin icon"));
        WebElement gitHubLogo = driver.findElement(By.linkText("Github icon"));
        WebElement twitterLogo = driver.findElement(By.linkText("Twitter icon"));

        Assert.assertTrue(locateAboutMe().isDisplayed());

        Assert.assertTrue(locateTechStack().isDisplayed());

        Assert.assertTrue(locateContactForm().isDisplayed());

        Assert.assertTrue(davorMinchorov.isDisplayed());
        Assert.assertEquals(davorMinchorovText, "DAVOR MINCHOROV");

        Assert.assertTrue(locateBlogButton().isDisplayed());
        Assert.assertEquals(blogButtonText, "BLOG");

        Assert.assertTrue(picture.isDisplayed());

        Assert.assertTrue(linkedInLogo.isDisplayed());

        Assert.assertTrue(gitHubLogo.isDisplayed());

        Assert.assertTrue(twitterLogo.isDisplayed());
    }

    /**
     * Validating About me text
     *
     * @return void
     */
    public void checkAboutMe() {
        locateAboutMe();
        String aboutMeText = locateAboutMe().getText();
        Assert.assertEquals(aboutMeText, "About Me\n" +
                "I am a 30 year old web developer from Skopje, Macedonia, who studied software engineering at University" +
                " American College Skopje and have about 5 years of experience building custom web based solutions.\n" +
                "\n" +
                "Currently, I am working as a Senior PHP Developer for clients via Quantox Technology for about 16 months.\n" +
                "\n" +
                "I am also a Senior Freelance PHP Consultant via Adeva, an exclusive remote developers' network for about 3 years.\n" +
                "\n" +
                "Previously, I worked at:\n" +
                "Checkbox Marked Circle icon Tabellarius (June 2015 - March 2016, 9 months)\n" +
                "Checkbox Marked Circle icon New Media Corp (April 2016 - February 2017, 10 months)\n" +
                "Checkbox Marked Circle icon Intertec as part of the Routyx team (March 2017 - December 2017, 9 months)\n" +
                "\n" +
                "Also, I was a mentor at Adeva's Female Bootcamp 2018. You can read more about the bootcamp experience here");
    }

    /**
     * Validating Technology stack text
     *
     * @return void
     */
    public void checkTechnologyStackText() {
        locateTechStack();
        String technologyStackText = locateTechStack().getText();
        Assert.assertEquals(technologyStackText, "Technology Stack\n" +
                "The technology stack that I use depends on the project but I usually use and have experience" +
                " with the following languages, technologies, libraries and tools:\n" +
                "Front-End\n" + "HTML5\n" + "CSS3\n" + "JavaScript\n" + "Bootstrap\n" + "jQuery\n" + "VueJS\n" + "Webpack\n" +
                "Tailwind CSS\n" + "Back-End\n" + "PHP 7\n" + "Laravel\n" + "Lumen\n" + "NodeJS\n" + "ExpressJS\n" +
                "Databases\n" + "MySQL\n" + "MongoDB\n" + "Redis\n" + "Other\n" + "NGINX\n" + "Git\n" + "Ubuntu\n" +
                "Docker\n" + "PHPStorm\n" + "PHPUnit\n" + "Jenkins");
    }

    /**
     * Finds and asserts contact form.
     *
     * @return HomePage
     */
    public HomePage findContactForm() {
        locateContactForm();
        Assert.assertTrue(locateContactForm().isDisplayed());
        Assert.assertTrue(locateContactForm().isEnabled());

        return this;
    }

    /**
     * Sets valid full name and waits 5 seconds to avoid reCAPTCHA errors.
     *
     * @return HomePage
     * @throws InterruptedException
     */
    public HomePage setValidFullName() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[1]/input")).sendKeys("Miki Test");
        Thread.sleep(5000);

        return this;
    }

    /**
     * Sets valid mail name and waits 5 seconds to avoid reCAPTCHA errors.
     *
     * @return HomePage
     * @throws InterruptedException
     */
    public HomePage setValidMail() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys("mikitesting@gmail.com");
        Thread.sleep(5000);

        return this;
    }

    /**
     * Sets valid message name and waits 5 seconds to avoid reCAPTCHA errors.
     *
     * @return HomePage
     * @throws InterruptedException
     */
    public HomePage setValidMessage() throws InterruptedException {
        driver.findElement(By.name("message")).sendKeys("Hello Davor, it`s Miki testing");
        Thread.sleep(5000);

        return this;
    }

    /**
     * Clicks send button of the contact form
     *
     * @return HomePage
     * @throws InterruptedException
     */
    public HomePage clickSendButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/button")).click();
        Thread.sleep(2000);

        return this;
    }

    /**
     * Asserts successful sent message response.
     *
     * @return void
     */
    public void checkSuccessfulSentMessageAlert() {
        WebElement successfullySentMessage = driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/div[1]"));
        Assert.assertTrue(successfullySentMessage.isDisplayed());

        successfullySentMessage.getText();
        Assert.assertEquals(successfullySentMessage.getText(), "Thank you! Your message was sent successfully. I will respond as soon as possible.");
    }

    /**
     * Asserts any of the error sent messages response for each field on the contact form
     *
     * @return void
     */
    public void checkUnsuccessfulSentMessageAlert() {
        if (locateUnsuccessfullySentMessageAlert().isDisplayed()) {

            String unsuccessfullySentMessage = locateUnsuccessfullySentMessageAlert().getText();
            Assert.assertEquals(unsuccessfullySentMessage, "Oh oh, there were errors.");
            System.out.println("Error text shown.");

            if (driver.findElements(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[1]/span[2]")).size() > 0) {

                String nameFieldIsRequiredMessage = locateNameFieldIsRequiredMessageAlert().getText();

                Assert.assertEquals(nameFieldIsRequiredMessage, "The name field is required.");
                System.out.println("Name field error text shown and passed.");
            } else if (driver.findElements(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[2]/span[2]")).size() > 0) {

                String emailFieldIsRequiredMessage = locateEmailFieldIsRequiredMessageAlert().getText();

                Assert.assertEquals(emailFieldIsRequiredMessage, "The email field is required.");
                System.out.println("Email field error text shown and passed.");

            } else if (driver.findElements(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[3]/span[2]")).size() > 0) {

                String messageFieldIsRequiredMessage = locateMessageFieldIsRequiredMessageAlert().getText();

                Assert.assertEquals(messageFieldIsRequiredMessage, "The message field is required.");
                System.out.println("Message field error text shown and passed.");
            } else {
                System.out.println("Some of the error messages not working properly!");
            }
        }
    }

    /**
     * Declaring all the WebElements that should appear when empty message is forced to send,
     * and getting the text from them then asserts the text.
     *
     * @return void
     */
    public void checkEmptyFormSendMessagesAlert() {
        locateUnsuccessfullySentMessageAlert();
        String unsuccessfullySentMessageText = locateUnsuccessfullySentMessageAlert().getText();

        locateNameFieldIsRequiredMessageAlert();
        String nameFieldIsRequiredMessage = locateNameFieldIsRequiredMessageAlert().getText();

        locateEmailFieldIsRequiredMessageAlert();
        String emailFieldIsRequiredMessage = locateEmailFieldIsRequiredMessageAlert().getText();

        locateMessageFieldIsRequiredMessageAlert();
        String messageFieldIsRequiredMessage = locateMessageFieldIsRequiredMessageAlert().getText();

        //Assertions for every message that is displayed and that is correct text.
        Assert.assertTrue(locateUnsuccessfullySentMessageAlert().isDisplayed());
        Assert.assertEquals(unsuccessfullySentMessageText, "Oh oh, there were errors.");

        Assert.assertTrue(locateNameFieldIsRequiredMessageAlert().isDisplayed());
        Assert.assertEquals(nameFieldIsRequiredMessage, "The name field is required.");

        Assert.assertTrue(locateEmailFieldIsRequiredMessageAlert().isDisplayed());
        Assert.assertEquals(emailFieldIsRequiredMessage, "The email field is required.");

        Assert.assertTrue(locateMessageFieldIsRequiredMessageAlert().isDisplayed());
        Assert.assertEquals(messageFieldIsRequiredMessage, "The message field is required.");
    }

    /**
     * Finds and asserts if the hyperlinks are enabled and displayed.
     *
     * @param String linkText
     * @return WebElement find
     */
    public WebElement findHyperlink(WebElement find) {
        this.find = find;

        Assert.assertTrue(find.isEnabled());
        Assert.assertTrue(find.isDisplayed());

        return find;
    }

    /**
     * Gets the color as Hex and asserts if it`s the expected color.
     *
     * @param String expectedColourAsHex
     * @return HomePage
     */
    public HomePage getHyperlinkColor(String expectedColourAsHex) {
        String getElementColour = findHyperlink(find).getCssValue("color");

        String HexColor = Color.fromString(getElementColour).asHex();
        Assert.assertEquals(HexColor, expectedColourAsHex);

        return this;
    }

    /**
     * Navigates to second tab.
     *
     * @return void
     */
    private void navigateToSecondTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
    }

    /**
     * It closes the first tab, so the script can continue with next tests searching for elements
     * on the right page.
     *
     * @return void
     */
    public void closeTab() {
        String originalHandle = driver.getWindowHandle();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }

        driver.switchTo().window(originalHandle);
    }

    /**
     * Clicks on the links and asserts URLS
     *
     * @param String expectedContains
     * @return void
     */
    public void clickAndCheckLink(String expectedContains) {

        String getLinkAsString = findHyperlink(find).getAttribute("href");
        Assert.assertTrue(getLinkAsString.contains(expectedContains));

        find.click();

        navigateToSecondTab();
        String tabUrl = driver.getCurrentUrl();
        Assert.assertTrue(tabUrl.contains(expectedContains));
        closeTab();
    }

    /**
     * Hover example. At this moment I don`t test the hovers over links because I don`t have the requirements.
     */
    public void hoverQuantoxHyperlink() {
        WebElement quantoxLink = driver.findElement(By.linkText("Quantox Technology"));
        actions.moveToElement(quantoxLink).perform();
    }

    /**
     * Checking for broken links on the page.
     *
     * @return void
     */
    public void brokenLinksCheck() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();

        while (it.hasNext()) {
            url = it.next().getAttribute("href");

            System.out.println(url);

            if (url == null || url.isEmpty()) {
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

            if (!url.startsWith("https://davorminchorov.com/")) {
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }

            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                int respCode = huc.getResponseCode();

                if (respCode >= 400) {
                    System.out.println(url + " is a broken link");
                } else {
                    System.out.println(url + " is a valid link");
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
