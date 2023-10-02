package Steps;

import io.qameta.allure.Step;

public interface IProductsAndServicesSteps {


    @Step("Click on Prdouct N:{0}")
    IProductsAndServicesSteps clickOnProduct(int index);

    @Step("Set Min Price: {0}")
    IProductsAndServicesSteps setMinPrice(Integer minPrice);

    @Step("Set Max Price: {0}")
    IProductsAndServicesSteps setMaxPrice(Integer maxPrice);

    @Step("Click on 'ძებნა' Button and Wait Until jQuery Requests Complete")
    IProductsAndServicesSteps clickOnDzebnaButton();

    @Step("Add first returned item to favorites list")
    IProductsAndServicesSteps addFirstOfferToFavorites();

    @Step("Sort By Price Decrease")
    IProductsAndServicesSteps selectSortByPriceDecrease();
}
