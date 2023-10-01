package Steps;

import Pages.KvebaPageObject;
import io.qameta.allure.Step;

public class KvebaPageSteps extends CommonPartSteps {
    public KvebaPageObject page = new KvebaPageObject();

    @Step
    public KvebaPageSteps clickOnSusiSubcategory() {
        page.sushiCategory.scrollIntoView(false).click();
        return new KvebaPageSteps();
    }

    @Override
    @Step("Set Min Price: {0}")
    public KvebaPageSteps setMinPrice(Integer minPrice) {
        super.setMinPrice(minPrice);
        return this;
    }

    @Override
    @Step("Set Max Price: {0}")
    public KvebaPageSteps setMaxPrice(Integer maxPrice) {
        super.setMaxPrice(maxPrice);
        return this;
    }

    @Override
    @Step("Click on 'ძებნა' Button and Wait Until jQuery Requests Complete")
    public KvebaPageSteps clickOnDzebnaButton() {
        super.clickOnDzebnaButton();
        return this;
    }

    @Override
    @Step("add first returned item to favorites list")
    public KvebaPageSteps addFirstOfferToFavorites() {
        super.addFirstOfferToFavorites();
        return this;
    }

    @Override
    @Step("Sort By Price Decrease")
    public KvebaPageSteps selectSortByPriceDecrease() {
        super.selectSortByPriceDecrease();
        return this;
    }
}
