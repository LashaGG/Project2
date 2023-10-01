package Pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class DasvenebaPage {
    public SelenideElement
            minPriceInput = $("#minprice", 1),
            maxPriceInput = $("#maxprice", 1),
            dzebnaButton = $(".submit-button", 1);

    public List<SelenideElement> currentPricesList = $$(".deal-voucher-price:not([style*='text-decoration: line-through;'])");


}
