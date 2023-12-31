package Steps;

import Pages.KvebaPageObject;
import io.qameta.allure.Step;

public class KvebaPageSteps implements IProductsAndServicesSteps {
    public KvebaPageObject page = new KvebaPageObject();

    @Step
    public KvebaPageSteps click() {
        page.sushiCategory.scrollIntoView(false).click();
        return this;
    }


    @Override
    @Step
    public KvebaPageSteps clickOnProduct(int index) {
        new ProductsAndServicesSteps().clickOnProduct(index);
        return this;
    }

    @Override
    @Step
    public KvebaPageSteps setMinPrice(Integer minPrice) {
        new ProductsAndServicesSteps().setMinPrice(minPrice);
        return this;
    }

    @Override
    @Step
    public KvebaPageSteps setMaxPrice(Integer maxPrice) {
        new ProductsAndServicesSteps().setMinPrice(maxPrice);
        return this;
    }

    @Override
    @Step
    public KvebaPageSteps clickOnDzebnaButton() {
        new ProductsAndServicesSteps().clickOnDzebnaButton();
        return this;
    }

    @Override
    @Step
    public KvebaPageSteps addFirstOfferToFavorites() {
        new ProductsAndServicesSteps().addFirstOfferToFavorites();
        return this;
    }

    @Override
    @Step
    public KvebaPageSteps selectSortByPriceDecrease() {
        new ProductsAndServicesSteps().selectSortByPriceDecrease();
        return this;
    }
}
