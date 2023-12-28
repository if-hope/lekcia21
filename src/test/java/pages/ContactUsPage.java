package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ContactUsPage extends AbstractPage{

    private final SelenideElement userNameField = $("[name='name']");
    private final SelenideElement emailField = $("[name='email']");
    private final SelenideElement messageTextArea = $("[name='message']");
    private final SelenideElement emailErrorMessage = $("[id='email-error']");
    private final SelenideElement privacyPolicyCheckbox = $("[name='privacy-policy-agreement']");
    private final SelenideElement captchaDiv = $("[class='footer__controls footer__controls_visible']");

    public SelenideElement getUserNameField() {
        return userNameField;
    }

    public SelenideElement getEmailField() {
        return emailField;
    }

    public SelenideElement getMessageTextArea() {
        return messageTextArea;
    }

    public SelenideElement getEmailErrorMessage() {
        return emailErrorMessage;
    }

    public SelenideElement getPrivacyPolicyCheckbox() {
        return privacyPolicyCheckbox;
    }

    public SelenideElement getCaptchaDiv() {
        return captchaDiv;
    }

    public ContactUsPage openContactUsPage(){
           Selenide.open("https://hire-tester.com/who-we-are/");
        return this;
    }

    public ContactUsPage fillForm(String name, String email, String textArea){
        getUserNameField().shouldBe(Condition.visible).sendKeys(name);
        //userNameField.shouldBe(Condition.visible).sendKeys(name);
        getEmailField().shouldBe(Condition.visible).sendKeys(email);
        getMessageTextArea().shouldBe(Condition.visible).sendKeys(textArea);
        return this;
    }

    public ContactUsPage checkPrivacyPolicy(){
        getPrivacyPolicyCheckbox().shouldBe(Condition.hidden).click();
        //clickJS(privacyPolicyCheckbox);
        return this;
    }


}
