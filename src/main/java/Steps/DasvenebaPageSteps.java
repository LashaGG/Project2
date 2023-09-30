package Steps;

import Pages.SwoopGeDasvenebaPage;
import Pages.SwoopGeMainPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DasvenebaPageSteps {
    public SwoopGeDasvenebaPage page = new SwoopGeDasvenebaPage();


    @Step("Set Min Price: {0}")
    public DasvenebaPageSteps setMinPrice(Integer minPrice) {
        page.minPriceInput.scrollTo().sendKeys(minPrice.toString());
        return this;
    }

    @Step("Set Max Price: {0}")
    public DasvenebaPageSteps setMaxPrice(Integer maxPrice) {
        page.minPriceInput.scrollTo().sendKeys(maxPrice.toString());
        return this;
    }

    @Step("Accept Cookies")
    public DasvenebaPageSteps acceptCookies() {
        new MainPageSteps().acceptCookies();
        return this;
    }


}
