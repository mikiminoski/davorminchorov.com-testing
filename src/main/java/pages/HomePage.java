package pages;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
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
    private WebDriverWait wait;
    private WebElement contactForm;
    private String url;
    HttpURLConnection huc;
    private WebElement find;

    Actions actions = new Actions(driver);


    public WebElement findBlog() {

        WebElement blogButton = driver.findElement(By.xpath("/html/body/div/nav/a[2]"));
        Assert.assertTrue(blogButton.isDisplayed());

        return blogButton;
    }

    public BlogPage clickBlog() {

        findBlog().click();

        return new BlogPage();
    }

    public void validateScreen() {

        WebElement aboutMe = driver.findElement(By.xpath("/html/body/div/main/div/div/div[2]/div[1]"));
        Assert.assertTrue(aboutMe.isDisplayed());

        WebElement techStack = driver.findElement(By.xpath("/html/body/div/main/div/div/div[2]/div[2]"));
        Assert.assertTrue(techStack.isDisplayed());

        contactForm = driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form"));
        Assert.assertTrue(contactForm.isDisplayed());

        WebElement davorMinchorov = driver.findElement(By.xpath("/html/body/div/nav/a[1]"));
        String davorMinchorovText = davorMinchorov.getText();
        Assert.assertTrue(davorMinchorov.isDisplayed());
        Assert.assertEquals(davorMinchorovText, "DAVOR MINCHOROV");

        WebElement blogButton = driver.findElement(By.xpath("/html/body/div/nav/a[2]"));
        String blogButtonText = blogButton.getText();
        Assert.assertTrue(blogButton.isDisplayed());
        Assert.assertEquals(blogButtonText, "BLOG");

        WebElement picture = driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/div/img"));
        Assert.assertTrue(picture.isDisplayed());

        WebElement linkedInLogo = driver.findElement(By.linkText("Linkedin icon"));
        Assert.assertTrue(linkedInLogo.isDisplayed());

        WebElement gitHubLogo = driver.findElement(By.linkText("Github icon"));
        Assert.assertTrue(gitHubLogo.isDisplayed());

        WebElement twitterLogo = driver.findElement(By.linkText("Twitter icon"));
        Assert.assertTrue(twitterLogo.isDisplayed());

    }

    public void checkAboutMe() {
        String aboutMeText = driver.findElement(By.xpath("/html/body/div/main/div/div/div[2]/div[1]")).getText();
        Assert.assertEquals(aboutMeText, "About Me\n" +
                "I am a 30 year old web developer from Skopje, Macedonia, who studied software engineering at University" +
                " American College Skopje and have about 5 years of experience building custom web based solutions.\n" +
                "\n" +
                "Currently, I am working as a Senior PHP Developer for clients via Quantox Technology for about 15 months.\n" +
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

    public void checkTechnologyStackText() {
        String technologyStackText = driver.findElement(By.xpath("/html/body/div/main/div/div/div[2]/div[2]/article")).getText();
        Assert.assertEquals(technologyStackText, "Technology Stack\n" +
                "The technology stack that I use depends on the project but I usually use and have experience" +
                " with the following languages, technologies, libraries and tools:\n" +
                "Front-End\n" + "HTML5\n" + "CSS3\n" + "JavaScript\n" + "Bootstrap\n" + "jQuery\n" + "VueJS\n" + "Webpack\n" +
                "Tailwind CSS\n" + "Back-End\n" + "PHP 7\n" + "Laravel\n" + "Lumen\n" + "NodeJS\n" + "ExpressJS\n" +
                "Databases\n" + "MySQL\n" + "MongoDB\n" + "Redis\n" + "Other\n" + "NGINX\n" + "Git\n" + "Ubuntu\n" +
                "Docker\n" + "PHPStorm\n" + "PHPUnit\n" + "Jenkins");
    }

    public void findContactForm() {
        contactForm = driver.findElement(By.tagName("form"));
        Assert.assertTrue(contactForm.isDisplayed());
        Assert.assertTrue(contactForm.isEnabled());
    }

    public void setValidFullName() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[1]/input")).sendKeys("Miki Test");
        Thread.sleep(5000);
    }


    public void setValidMail() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys("mikitesting@gmail.com");
        Thread.sleep(5000);
    }

    public void setValidMessage() throws InterruptedException {
        driver.findElement(By.name("message")).sendKeys("Hello Davor, it`s Miki testing");
        Thread.sleep(5000);
    }

    public void clickSendButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/button")).click();
        Thread.sleep(2000);
    }

    public void checkSuccessfulSentMessageReport() {
        WebElement successfullySentMessage = driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/div[1]"));
        Assert.assertTrue(successfullySentMessage.isDisplayed());

        successfullySentMessage.getText();
        Assert.assertEquals(successfullySentMessage.getText(), "Thank you! Your message was sent successfully. I will respond as soon as possible.");
    }

    public void checkUnsuccessfulSentMessageReport() {

        if (driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/div[1]")).isDisplayed()) {

            String unsuccessfullySentMessage = driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/div[1]")).getText();
            Assert.assertEquals(unsuccessfullySentMessage, "Oh oh, there were errors.");
            System.out.println("Error text shown.");

            if (driver.findElements(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[1]/span[2]")).size() > 0) {

                String nameFieldIsRequiredMessage = driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[1]/span[2]")).getText();

                Assert.assertEquals(nameFieldIsRequiredMessage, "The name field is required.");
                System.out.println("Name field error text shown and passed.");
            } else if (driver.findElements(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[2]/span[2]")).size() > 0) {

                String emailFieldIsRequiredMessage = driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[2]/span[2]")).getText();

                Assert.assertEquals(emailFieldIsRequiredMessage, "The email field is required.");
                System.out.println("Email field error text shown and passed.");

            } else if (driver.findElements(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[3]/span[2]")).size() > 0) {

                String messageFieldIsRequiredMessage = driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[3]/span[2]")).getText();

                Assert.assertEquals(messageFieldIsRequiredMessage, "The message field is required.");
                System.out.println("Message field error text shown and passed.");
            } else {
                System.out.println("Some of the error messages not working properly!");
            }
        }
    }

    public void checkEmptyFormSendMessagesReport() {
        //Declaring all the WebElements that should appear when empty message is forced to send, and getting the text from them
        WebElement unsuccessfullySentMessageReport = driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/div[1]"));
        String unsuccessfullySentMessageText = driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/div[1]")).getText();

        WebElement nameFieldIsRequiredMessageReport = driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[1]/span[2]"));
        String nameFieldIsRequiredMessage = driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[1]/span[2]")).getText();

        WebElement emailFieldIsRequiredMessageReport = driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[2]/span[2]"));
        String emailFieldIsRequiredMessage = driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[2]/span[2]")).getText();

        WebElement messageFieldIsRequiredMessageReport = driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[3]/span[2]"));
        String messageFieldIsRequiredMessage = driver.findElement(By.xpath("/html/body/div/main/div/div/div[3]/div/div/form/label[3]/span[2]")).getText();

        //Assertions for every message that is displayed and that is correct text.
        Assert.assertTrue(unsuccessfullySentMessageReport.isDisplayed());
        Assert.assertEquals(unsuccessfullySentMessageText, "Oh oh, there were errors.");

        Assert.assertTrue(nameFieldIsRequiredMessageReport.isDisplayed());
        Assert.assertEquals(nameFieldIsRequiredMessage, "The name field is required.");

        Assert.assertTrue(emailFieldIsRequiredMessageReport.isDisplayed());
        Assert.assertEquals(emailFieldIsRequiredMessage, "The email field is required.");

        Assert.assertTrue(messageFieldIsRequiredMessageReport.isDisplayed());
        Assert.assertEquals(messageFieldIsRequiredMessage, "The message field is required.");
    }

    public WebElement findHyperlink(WebElement find) {
        this.find = find;
        Assert.assertTrue(find.isEnabled());
        Assert.assertTrue(find.isDisplayed());
        return find;
    }

    public void getHyperlinkColor(String expectedColourAsHex) {
        String getElementColour = findHyperlink(find).getCssValue("color");

        String HexColor = Color.fromString(getElementColour).asHex();
        Assert.assertEquals(HexColor, expectedColourAsHex);
    }

    private void navigateToSecondTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

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

    public void clickAndCheckLink(String expectedContains) {

        String getLinkAsString = findHyperlink(find).getAttribute("href");
        Assert.assertTrue(getLinkAsString.contains(expectedContains));

        find.click();

        navigateToSecondTab();
        String tabUrl = driver.getCurrentUrl();
        Assert.assertTrue(tabUrl.contains(expectedContains));
        closeTab();
    }

    /*
    Hover example. At this moment I don`t test the hovers over links because I don`t have the requirements.
     */
    public void hoverQuantoxHyperlink() {
        WebElement quantoxLink = driver.findElement(By.linkText("Quantox Technology"));
        actions.moveToElement(quantoxLink).perform();
    }

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
// TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void validateAdevaHyperlink() throws IOException, InvalidFormatException {

        String adevaURL = driver.findElement(By.linkText("Quantox Technology")).getAttribute("href");

        Assert.assertEquals(adevaURL,getExcelData("Hyperlinks",2,2));

    }

    public String getExcelData(String sheetName , int rowNum , int colNum) throws InvalidFormatException, IOException{
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\QA\\Automation\\Projects\\TestingD\\data\\davorminchorov_Test_Data_Hyperlinks.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        String data = row.getCell(colNum).getStringCellValue();

        return data;
    }
}
