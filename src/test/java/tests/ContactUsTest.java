package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsTest extends AbstractTest{

    @Test
    public void emailValidationTest(){
        ContactUsPage contactUsPage = new ContactUsPage().openContactUsPage()
                .fillForm("Nadia", "email", "Some text message");

        contactUsPage.getEmailErrorMessage().shouldHave(Condition.exactText("Your e-mail address must be in the following format: name@domain.com"));

    }

    @Test
    public void captchaAppearingTest() {
        ContactUsPage contactUsPage = new ContactUsPage().openContactUsPage()
                .fillForm("Nadia", "tester234532@gmail.com", "Some text message")
                .checkPrivacyPolicy();

        contactUsPage.getCaptchaDiv().shouldBe(Condition.appear);

    }

}
