package Pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SwoopGeMainPage {

    private static SelenideElement getMenuButton(String section) {
        return $x("//div[@class='Menus']//a[contains(normalize-space()," + section + ")]");
    }

    public SelenideElement
            dasvenebaButton = getMenuButton("'დასვენება'"),
            kvebaButton = getMenuButton("'კვება'"),
            acceptCookiesButton = $(".acceptCookie");


}
