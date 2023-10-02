package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPageObject {
    public SelenideElement
            checkoutButton = $x("//div[@class='checkout__button']"),
            shareButton = $x("//span[text()='გაზიარება']");

}
