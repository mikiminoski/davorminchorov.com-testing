package Tests.Homepage;

import Tests.BaseSet;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestingContactForm extends BaseSet {

    HomePage homepage = new HomePage();

    /*
    Test ID: n6
    Testing the form and checking the successful message
     */
    @Test
    public void send_Valid_Message() throws InterruptedException {

        homepage.findContactForm();
        homepage.setValidFullName();
        homepage.setValidMail();
        homepage.setValidMessage();
        homepage.clickSendButton();
        homepage.checkSuccessfulSentMessageReport();
    }

    /*
    Test ID: n7
    Trying to send message withoud Full Name field fulfilled
    Than checking the messages shown on the screen.
     */
    @Test
    public void send_Message_Without_Full_Name() throws InterruptedException {

        homepage.findContactForm();
        homepage.setValidMail();
        homepage.setValidMessage();
        homepage.clickSendButton();
        homepage.checkUnsuccessfulSentMessageReport();
    }

    /*
    Test ID: n8
    Trying to send message without eMail field fulfilled
    Than checking the messages shown on the screen.
     */
    @Test
    public void send_Message_Without_Email() throws InterruptedException {

        homepage.findContactForm();
        homepage.setValidFullName();
        homepage.setValidMessage();
        homepage.clickSendButton();
        homepage.checkUnsuccessfulSentMessageReport();
    }

    /*
    Test ID: n9
    Trying to send message without message field fulfilled
    Than checking the messages shown on the screen.
     */
    @Test
    public void send_Message_Without_Text() throws InterruptedException {

        homepage.findContactForm();
        homepage.setValidFullName();
        homepage.setValidMail();
        homepage.clickSendButton();
        homepage.checkUnsuccessfulSentMessageReport();
    }

    /*
    Test ID: n10
    Testing if all error messages are shown up under the each form
    when trying to click send button without filling out any of the forms.
     */
    @Test
    public void click_Send_Button_Without_Filling_Out_Any_Form() throws InterruptedException {

        homepage.findContactForm();
        homepage.clickSendButton();
        homepage.checkEmptyFormSendMessagesReport();
    }
}