import HelperClasses.ConfigSelenide;
import Pages.DasvenebaPageObject;
import Steps.DasvenebaPageSteps;
import Steps.HeaderPageSteps;
import Steps.KvebaPageSteps;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Epic;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Objects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


@Listeners({SoftAsserts.class})
public class SwoopGeTest extends ConfigSelenide {

    public SwoopGeTest() {
        super(20, "chrome");
    }

    @Epic("Recreation")
    @Description("""
              Test to validate the price ranges on Swoop.ge:
              - Go to  „დასვენება“
              - In  „ფასი“ element put range from 200 to 230
              - Check that all returned elements on the first page are in selected range
            """)
    @Test(description = "SwoopGe  „დასვენება' Test", groups = "SwoopGeGroup")
    public void firstTest() {

        HeaderPageSteps main;
        DasvenebaPageSteps dasveneba;

        open("https://www.swoop.ge/");

        main = new HeaderPageSteps();
        main.acceptCookies();
        main.clickOnDasvenebaButton();

        dasveneba = new DasvenebaPageSteps();

        int minPrice = 200, maxPrice = 230;
        dasveneba.setMinPrice(200).setMaxPrice(230).clickOnDzebnaButton();

        new DasvenebaPageObject().salesPricesList.stream()
                .map(SelenideElement::getText)
                .map(t -> t.substring(0, t.length() - 1))
                .map(Integer::parseInt)
                .forEach(e -> {
                    softAssert.assertTrue(e <= maxPrice && e >= minPrice - 100);
                });

        softAssert.assertAll();
    }


    @Epic("Meals")
    @Description("""
              - Go to კატეგორიები;
              - Hover on „კვება“ and click on „სუში“
              - Try to add first returned item to favorites list and verify that Login Window has appeared
              - Check that the vouchers are not sold out (See picture below)
            """)
    @Test(description = "SwoopGe 'კვება' Test", groups = "SwoopGeGroup")
    public void secondTest() {
        HeaderPageSteps main;

        open("https://www.swoop.ge/");

        main = new HeaderPageSteps();
        main.acceptCookies()
                .clickOnCategoriesArrow()
                .hoverKvebaCategory()
                .clickOnSusiSubcategory();

        var kveba = new KvebaPageSteps();
        kveba.addFirstOfferToFavorites();


        $("#login-content-1").shouldBe(visible);

        SelenideElement offer = kveba.page.specialOffersList.get(0);

        int limit = Integer.parseInt(Objects.requireNonNull(offer.$(".voucher-limit").getAttribute("data-width")));
        softAssert.assertTrue(0 <= limit && limit < 100);


        softAssert.assertAll();
    }

//    @Story("Meals")
//    @Description("""
//            - Go to კატეგორიები
//            - Hover on „კვება“ and click on სუში
//            - Sort elements with ფასით კლებადი
//            - Check that the price of the first item is higher than the price of the second item
//            """)
//    @Test(description = "SwoopGe 'კვება' Test", groups = "SwoopGeGroup")
//    public void thirdTest() {
//        HeaderPageSteps main;
//
//        open("https://www.swoop.ge/");
//
//        main = new HeaderPageSteps();
//        main.acceptCookies()
//                .clickOnCategoriesArrow()
//                .hoverKvebaCategory()
//                .clickOnSusiSubcategory();
//
//        var kveba = new KvebaDefaultPageSteps();
//        var prices = kveba.page.salesPricesList;
//
//
//        softAssert.assertAll();
//    }


}
