import HelperClasses.ConfigSelenide;
import Steps.DasvenebaPageSteps;
import Steps.MainPageSteps;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SwoopGeTest extends ConfigSelenide {


    @Story("recreation")
    @Description("""
              Test to validate the price ranges on Swoop.ge:
              1. Navigate to the Swoop.ge website.
              2. Click on a "დასვენება" section on the main page.
              3. Set the minimum and maximum price range for deals
              4. Verify that each deal price falls within the specified price range.
            """)
    @Test(description = "SwoopGe 'დასვენება' Test", groups = "SwoopGeGroup")
    public void recreation() throws InterruptedException {

        MainPageSteps main;
        DasvenebaPageSteps dasveneba;

        open("https://www.swoop.ge/");

        main = new MainPageSteps();
        main.acceptCookies();
        main.clickOnDasvenebaButton();

        dasveneba = new DasvenebaPageSteps();

        int minPrice = 230, maxPrice = 230;
        dasveneba.setMinPrice(200).setMaxPrice(230);

        List<SelenideElement> PricesList = $$(".deal-voucher-price:not([style*='text-decoration: line-through;'])");

        PricesList
                .stream()
                .filter(e -> e.is(Condition.visible))
                .map(e -> (e.getText()))
                .map(t -> t.substring(0, t.length() - 1))
                .map(t -> Integer.parseInt(t))
                .forEach(e -> {
                    softAssert.assertTrue(e >= maxPrice && e <= maxPrice);
                });

        softAssert.assertAll();
    }

    @Test
    public void t(){
        open("https://www.swoop.ge/");
        Assert.fail();
    }

}
