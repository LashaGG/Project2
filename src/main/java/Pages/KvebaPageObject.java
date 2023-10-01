package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

public class KvebaPageObject extends CommonPartPageObject {

    public SelenideElement sushiCategory = Categories.$(byText("სუში"));

}
