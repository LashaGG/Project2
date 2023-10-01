package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CommonPartPageObject extends HeaderPageObject {

    public SelenideElement Categories = $("#sidebar").$(".category-ul.main-category-ul");
    public List<SelenideElement>
            specialOffersList = $$(".special-offer"),
            salesPricesList = $$(By.xpath("//p[contains(@class, 'deal-voucher-price') " +
                    "and not(contains(@style, 'text-decoration: line-through;'))]")).filterBy(visible);

    public SelenideElement
            sortSelect = $("#sort"),
            minPriceInput = $("#minprice", 1),
            maxPriceInput = $("#maxprice", 1),
            dzebnaButton = $(".submit-button", 1);


}
