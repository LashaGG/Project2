package Steps;

import Pages.DasvenebaPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DasvenebaPageSteps {
    public DasvenebaPage page = new DasvenebaPage();


    @Step("Set Min Price: {0}")
    public DasvenebaPageSteps setMinPrice(Integer minPrice) {
        page.minPriceInput.scrollIntoView(false).sendKeys(minPrice.toString());
        return this;
    }

    @Step("Set Max Price: {0}")
    public DasvenebaPageSteps setMaxPrice(Integer maxPrice) {
        page.maxPriceInput.scrollIntoView(false).sendKeys(maxPrice.toString());
        return this;
    }

    @Step
    public DasvenebaPageSteps clickOnDzebnaButton() {
        Selenide.executeJavaScript("arguments[0].click()",page.dzebnaButton);
        return this;
    }


}
