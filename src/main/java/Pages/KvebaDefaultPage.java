package Pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class KvebaDefaultPage {

    protected SelenideElement Categories = $("#sidebar").$(".category-ul.main-category-ul");
    public SelenideElement sushiCategory = Categories.$(byText("სუში"));
    public List<SelenideElement> specialOffersList = $$(".special-offer");

}
