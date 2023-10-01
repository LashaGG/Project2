package Steps;

import Pages.DasvenebaPageObject;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class DasvenebaPageSteps extends CommonPartSteps {
    public DasvenebaPageObject page = new DasvenebaPageObject();

    @Override
    @Step("Set Min Price: {0}")
    public DasvenebaPageSteps setMinPrice(Integer minPrice) {
        super.setMinPrice(minPrice);
        return this;
    }

    @Override
    @Step("Set Max Price: {0}")
    public DasvenebaPageSteps setMaxPrice(Integer maxPrice) {
        super.setMaxPrice(maxPrice);
        return this;
    }

    @Override
    @Step("Click on 'ძებნა' Button and Wait Until jQuery Requests Complete")
    public DasvenebaPageSteps clickOnDzebnaButton() {
        super.clickOnDzebnaButton();
        return this;
    }

    @Override
    @Step("add first returned item to favorites list")
    public DasvenebaPageSteps addFirstOfferToFavorites() {
        super.addFirstOfferToFavorites();
        return this;
    }

    @Override
    @Step("Sort By Price Decrease")
    public DasvenebaPageSteps selectSortByPriceDecrease() {
        super.selectSortByPriceDecrease();
        return this;
    }
}
