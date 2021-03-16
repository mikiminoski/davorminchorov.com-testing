package Tests.Homepage;

import Tests.BaseSet;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestingContactForm extends BaseSet {

    HomePage homepage = new HomePage();

    /**
     * Test ID: n6
     *
     * @throws InterruptedException
     */
    @Test
    public void send_valid_message() throws InterruptedException {
        homepage.findContactForm();
        homepage.setValidFullName();
        homepage.setValidMail();
        homepage.setValidMessage();
        homepage.clickSendButton();
        homepage.checkSuccessfulSentMessageReport();
    }

    /**
     * Test ID: n7
     *
     * @throws InterruptedException
     */
    @Test
    public void send_message_without_full_name() throws InterruptedException {
        homepage.findContactForm();
        homepage.setValidMail();
        homepage.setValidMessage();
        homepage.clickSendButton();
        homepage.checkUnsuccessfulSentMessageReport();
    }

    /**
     * Test ID: n8
     *
     * @throws InterruptedException
     */
    @Test
    public void send_message_without_email() throws InterruptedException {
        homepage.findContactForm();
        homepage.setValidFullName();
        homepage.setValidMessage();
        homepage.clickSendButton();
        homepage.checkUnsuccessfulSentMessageReport();
    }

    /**
     * Test ID: n9
     *
     * @throws InterruptedException
     */
    @Test
    public void send_message_without_text() throws InterruptedException {
        homepage.findContactForm();
        homepage.setValidFullName();
        homepage.setValidMail();
        homepage.clickSendButton();
        homepage.checkUnsuccessfulSentMessageReport();
    }

    /**
     * Test ID: n10
     *
     * @throws InterruptedException
     */
    @Test
    public void click_send_button_without_filling_out_any_form() throws InterruptedException {
        homepage.findContactForm();
        homepage.clickSendButton();
        homepage.checkEmptyFormSendMessagesReport();
    }
}