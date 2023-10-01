package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

public class DasvenebaPageObject extends CommonPartPageObject {
    public SelenideElement mtisKurortiCategory = Categories.$(byText("მთის კურორტები"));

}
