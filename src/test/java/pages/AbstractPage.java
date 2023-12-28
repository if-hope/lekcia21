package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.$;

public class AbstractPage {

    private final SelenideElement searchIcon = $("div>[class='quick-search__icon']");
    private final SelenideElement searchField = $("[class='quick-search__field']");
    private final SelenideElement searchSubmit = $("button>[class='quick-search__icon']");

    public SelenideElement getSearchIcon() {
        return searchIcon;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }

    public SelenideElement getSearchSubmit() {
        return searchSubmit;
    }

    public AbstractPage openMainPage(){
        Selenide.open("https://hire-tester.com");
        return this;
    }


    public SearchResultPage search(String searchText){
        getSearchIcon().shouldBe(Condition.visible).click();
        getSearchField().shouldBe(Condition.visible).sendKeys(searchText);
        getSearchSubmit().shouldBe(Condition.visible).click();
        return new SearchResultPage();
    }

    public void clickJS(SelenideElement se){
        Selenide.executeJavaScript("arguments[0].click();", se);
    }

}
