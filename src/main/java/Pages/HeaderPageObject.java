package Pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;


public class HeaderPageObject {


    protected SelenideElement Menus = $(".Menus");

    public SelenideElement acceptCookiesButton = $(".acceptCookie");

    public SelenideElement //Header Buttons;
            dasvenebaButton = Menus.$(byText("დასვენება")),
            kvebaButton = Menus.$(byText("კვება")),
            categoiresArrow = $(".categoriesArrow"),
            login = $(".swoop-login");

    public SelenideElement //Categoires
            kinoCategory = $(By.cssSelector("[cat_id='CatId-0']")),
            estetikaCategory = $(By.cssSelector("[cat_id='CatId-1']")),
            dasvenebaCategory = $(By.cssSelector("[cat_id='CatId-2']")),
            kvebaCategory = $(By.cssSelector("[cat_id='CatId-3']"));


    public SelenideElement // 'კვება' subcategories
            sushiSubcategory = kvebaCategory.$(withText("სუში")),
            restoraniSubcategory = kvebaCategory.$(withText("რესტორანი"));

}
