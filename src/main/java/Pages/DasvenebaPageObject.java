package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

public class DasvenebaPageObject extends ProductsAndServicesPageObject {
    public SelenideElement mtisKurortiCategory = Categories.$(byText("მთის კურორტები"));

}
