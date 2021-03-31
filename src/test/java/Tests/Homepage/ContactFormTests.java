package Tests.Homepage;

import Tests.BaseSet;
import org.testng.annotations.Test;
import pages.HomePage;

import static pages.HomePage.getHomePage;

public class ContactFormTests extends BaseSet {

    HomePage homepage = getHomePage();

    /**
     * Test ID: n6
     *
     * @throws InterruptedException
     */
    @Test
    public void send_valid_message() throws InterruptedException {
        homepage.findContactForm()
                .setValidFullName()
                .setValidMail()
                .setValidMessage()
                .clickSendButton()
                .checkSuccessfulSentMessageAlert();
    }

    /**
     * Test ID: n7
     *
     * @throws InterruptedException
     */
    @Test
    public void send_message_without_full_name() throws InterruptedException {
        homepage.findContactForm()
                .setValidMail()
                .setValidMessage()
                .clickSendButton()
                .checkUnsuccessfulSentMessageAlert();
    }

    /**
     * Test ID: n8
     *
     * @throws InterruptedException
     */
    @Test
    public void send_message_without_email() throws InterruptedException {
        homepage.findContactForm()
                .setValidFullName()
                .setValidMessage()
                .clickSendButton()
                .checkUnsuccessfulSentMessageAlert();
    }

    /**
     * Test ID: n9
     *
     * @throws InterruptedException
     */
    @Test
    public void send_message_without_text() throws InterruptedException {
        homepage.findContactForm()
                .setValidFullName()
                .setValidMail()
                .clickSendButton()
                .checkUnsuccessfulSentMessageAlert();
    }

    /**
     * Test ID: n10
     *
     * @throws InterruptedException
     */
    @Test
    public void click_send_button_without_filling_out_any_form() throws InterruptedException {
        homepage.findContactForm()
                .clickSendButton()
                .checkEmptyFormSendMessagesAlert();
    }
}