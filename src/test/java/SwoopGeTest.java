import Data.DataBases.UsersDataBase;
import HelperClasses.ConfigSelenide;
import Pages.DasvenebaPageObject;
import Steps.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.springframework.context.annotation.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


@Listeners({SoftAsserts.class})
public class SwoopGeTest extends ConfigSelenide {
    public SwoopGeTest() {
        super(60, "chrome");
    }


    @Test(enabled = false)
    public void goToSushi() {
        HeaderPageSteps main;

        main = new HeaderPageSteps();
        main.acceptCookies()
                .clickOnCategoriesArrow()
                .hoverKvebaCategory()
                .clickOnSusiSubcategory();

    }

    @BeforeMethod
    public void openDemoqa() {
        open("https://www.swoop.ge/");
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
                .forEach(e -> softAssert.assertTrue(e <= maxPrice && e >= minPrice - 100));

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
        goToSushi();

        var kveba = new KvebaPageSteps();
        kveba.addFirstOfferToFavorites();


        $("#login-content-1").shouldBe(visible);

        SelenideElement offer = kveba.page.specialOffersList.get(0);

        int limit = Integer.parseInt(Objects.requireNonNull(offer.$(".voucher-limit").getAttribute("data-width")));
        softAssert.assertTrue(0 <= limit && limit < 100);

        softAssert.assertAll();
    }

    @Story("Meals")
    @Description("""
            - Go to კატეგორიები
            - Hover on „კვება“ and click on სუში
            - Sort elements with ფასით კლებადი
            - Check that the price of the first item is higher than the price of the second item
            """)
    @Test(description = "SwoopGe 'კვება' elements Sort Test", groups = "SwoopGeGroup")
    public void thirdTest() {
        goToSushi();

        var kveba = new KvebaPageSteps();

        kveba.selectSortByPriceDecrease();

        String firstsPrice = kveba.page.salesPricesList.get(0).getText().replaceAll("[^0-9]", ""),
                secondsPrice = kveba.page.salesPricesList.get(1).getText().replaceAll("[^0-9]", "");

        softAssert.assertTrue(Integer.parseInt(firstsPrice) > Integer.parseInt(secondsPrice));

        softAssert.assertAll();
    }


    @Feature("Facebook Share")
    @Description("""
            - Go to კატეგორიები
            - Hover on „კვება“ and click on სუში
            - Navigate to the first returned item
            -Click on ‘გაზიარება’
            -Validate that window with Facebook login page has appeared
            """)
    @Test(description = "SwoopGe Share Test", groups = "SwoopGeGroup")
    public void forthTest() {
        goToSushi();

        new KvebaPageSteps().clickOnProduct(0);
        new ProductSteps().clickOnShareButton();

        switchTo().window(1);

        softAssert.assertEquals($("#homelink").getText(), "Facebook");

        softAssert.assertAll();
    }


    @Epic("Registration")
    @Description("""
            - Generate data for new user and insert it into the database
            - Register for new account ფიზიკური პირი;
            - Fill all mandatory fields, except Gender
            - Check that error message ‘გთხოვთ აირჩიოთ სქესი!’ is appear
            """)
    @Test(description = "SwoopGe Registration", groups = "SwoopGeGroup")
    public void fifthTest() throws SQLException {
        var db = new UsersDataBase();

        db.insertUser("Lasha", "Giorgadze", "551197560",
                "lashagiorgadze7777@gmail.com", "03-11-2004", "qwerty123");

        ResultSet user = db.executeQuery("SELECT TOP 1 * FROM Users ORDER BY id DESC");
        user.next();
        String[] dateParts = user.getString(6).split("-");
        String date = dateParts[2] + dateParts[1] + dateParts[0];


        new HeaderPageSteps().clickOnLoginButton();


        var loginPagesSteps = new LoginPageSteps();

        loginPagesSteps
                .clickRegistration()
                .enterFirstName(user.getString(2))
                .enterLastName(user.getString(3))
                .enterPhoneNumber(user.getString(4))
                .enterEmail(user.getString(5))
                .enterDateOfBirth(date)
                .enterPassword(user.getString(7))
                .enterConfirmPassword(user.getString(7))
                .clickOnRegisterButton();

        softAssert.assertEquals(loginPagesSteps.page.physicalInfoMassage.getText(), "გთხოვთ აირჩიოთ სქესი!");
        
        softAssert.assertAll();
    }


}
