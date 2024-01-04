package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.AbstractPage;
import pages.ContactUsPage;

import static com.codeborne.selenide.Selenide.$;

public class ContactUsTest extends AbstractTest{

    private static final Logger LOGGER = LogManager.getLogger(ContactUsTest.class);

    @Test
    public void emailValidationTest(){
        ContactUsPage contactUsPage = new ContactUsPage().openContactUsPage()
                .fillForm("Nadia", "email", "Some text message");
        LOGGER.trace("trace example");
        LOGGER.info("info example");
        LOGGER.debug("debug example");
        LOGGER.error("error example");

        Reporter.log("log from testng");
        contactUsPage.getEmailErrorMessage().shouldHave(Condition.exactText("Your e-mail address must be in the following format: name@domain.com"));

    }

    @Test
    public void captchaAppearingTest() {
        ContactUsPage contactUsPage = new ContactUsPage().openContactUsPage()
                .fillForm("Nadia", "tester234532@gmail.com", "Some text message")
                .checkPrivacyPolicy();

        contactUsPage.getCaptchaDiv().shouldBe(Condition.appear);

    }

    @Test
    public void getColorTest(){
        AbstractPage abstractPage = new AbstractPage();
        abstractPage.openMainPage().onHover();
    }

    @Test
    public void fileUploadTest(){
        Selenide.open("https://cgi-lib.berkeley.edu/ex/fup.html");
        String userDir = System.getProperty("user.dir");
        $("[name='upfile']").sendKeys(userDir + "\\src\\test\\resources\\testng.xml");
        System.out.println();
    }



}
