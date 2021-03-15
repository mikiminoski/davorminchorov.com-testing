package Tests.Homepage;

import Tests.BaseSet;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestingContactForm extends BaseSet {

    HomePage homepage = new HomePage();

    @Test
    public void send_valid_message() throws InterruptedException {
        homepage.findContactForm();
        homepage.setValidFullName();
        homepage.setValidMail();
        homepage.setValidMessage();
        homepage.clickSendButton();
        homepage.checkSuccessfulSentMessageReport();
    }

    @Test
    public void send_message_without_full_name() throws InterruptedException {
        homepage.findContactForm();
        homepage.setValidMail();
        homepage.setValidMessage();
        homepage.clickSendButton();
        homepage.checkUnsuccessfulSentMessageReport();
    }

    @Test
    public void send_message_without_email() throws InterruptedException {
        homepage.findContactForm();
        homepage.setValidFullName();
        homepage.setValidMessage();
        homepage.clickSendButton();
        homepage.checkUnsuccessfulSentMessageReport();
    }

    @Test
    public void send_message_without_text() throws InterruptedException {
        homepage.findContactForm();
        homepage.setValidFullName();
        homepage.setValidMail();
        homepage.clickSendButton();
        homepage.checkUnsuccessfulSentMessageReport();
    }

    @Test
    public void click_send_button_without_filling_out_any_form() throws InterruptedException {
        homepage.findContactForm();
        homepage.clickSendButton();
        homepage.checkEmptyFormSendMessagesReport();
    }
}