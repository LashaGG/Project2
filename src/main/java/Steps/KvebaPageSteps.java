package Steps;

import Pages.KvebaPageObject;
import io.qameta.allure.Step;

public class KvebaPageSteps implements IProductsAndServicesSteps {
    public KvebaPageObject page = new KvebaPageObject();

    @Override
    public KvebaPageSteps clickOnProduct(int index) {
        new ProductsAndServicesSteps().clickOnProduct(index);
        return this;
    }

    @Override
    @Step("Set Min Price: {0}")
    public KvebaPageSteps setMinPrice(Integer minPrice) {
        new ProductsAndServicesSteps().setMinPrice(minPrice);
        return this;
    }

    @Override
    @Step("Set Max Price: {0}")
    public KvebaPageSteps setMaxPrice(Integer maxPrice) {
        new ProductsAndServicesSteps().setMinPrice(maxPrice);
        return this;
    }

    @Override
    @Step("Click on 'ძებნა' Button and Wait Until jQuery Requests Complete")
    public KvebaPageSteps clickOnDzebnaButton() {
        new ProductsAndServicesSteps().clickOnDzebnaButton();
        return this;
    }

    @Override
    @Step("add first returned item to favorites list")
    public KvebaPageSteps addFirstOfferToFavorites() {
        new ProductsAndServicesSteps().addFirstOfferToFavorites();
        return this;
    }

    @Override
    @Step("Sort By Price Decrease")
    public KvebaPageSteps selectSortByPriceDecrease() {
        new ProductsAndServicesSteps().selectSortByPriceDecrease();
        return this;
    }
}
