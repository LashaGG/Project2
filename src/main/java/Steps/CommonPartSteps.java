package Steps;

import Pages.CommonPartPageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideWait;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CommonPartSteps extends HeaderPageSteps {

    public CommonPartPageObject page = new CommonPartPageObject();

    @Step("Set Min Price: {0}")
    public CommonPartSteps setMinPrice(Integer minPrice) {
        page.minPriceInput.scrollIntoView(false).sendKeys(minPrice.toString());
        return this;
    }

    @Step("Set Max Price: {0}")
    public CommonPartSteps setMaxPrice(Integer maxPrice) {
        page.maxPriceInput.scrollIntoView(false).sendKeys(maxPrice.toString());
        return this;
    }

    @Step("Click on 'ძებნა' Button and Wait Until jQuery Requests Complete")
    public CommonPartSteps clickOnDzebnaButton() {
        Selenide.executeJavaScript("arguments[0].click()", page.dzebnaButton.shouldHave(Condition.exist));
        Selenide.Wait().until(webDriver -> {
            return (Boolean) ((JavascriptExecutor) webDriver)
                    .executeScript("return jQuery.active == 0");
        });
        return this;
    }

    @Step("add first returned item to favorites list")
    public CommonPartSteps addFirstOfferToFavorites() {
        var offer = page.specialOffersList.get(0);
        offer.$(".dis-price").click();
        return this;
    }


}
