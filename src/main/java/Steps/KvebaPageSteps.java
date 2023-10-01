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
    public KvebaPageSteps setMinPrice(Integer minPrice) {
        super.setMinPrice(minPrice);
        return new KvebaPageSteps();
    }

    @Override
    public KvebaPageSteps setMaxPrice(Integer maxPrice) {
        super.setMaxPrice(maxPrice);
        return new KvebaPageSteps();
    }

    @Override
    public KvebaPageSteps clickOnDzebnaButton() {
        super.clickOnDzebnaButton();
        return new KvebaPageSteps();
    }

    @Override
    public KvebaPageSteps addFirstOfferToFavorites() {
        super.addFirstOfferToFavorites();
        return new KvebaPageSteps();

    }
}
