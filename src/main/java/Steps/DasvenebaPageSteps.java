package Steps;

import Pages.DasvenebaPageObject;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class DasvenebaPageSteps implements IProductsAndServicesSteps {
    public DasvenebaPageObject page = new DasvenebaPageObject();

    @Step
    public DasvenebaPageSteps clickOnMtisKurortiCategory() {
        page.mtisKurortiCategory.scrollIntoView(false).click();
        return this;//დავამატე რათა რამე განსხვავება ყოფილიყო
    }

    @Override
    public DasvenebaPageSteps clickOnProduct(int index) {
        new ProductsAndServicesSteps().clickOnProduct(index);
        return this;
    }

    @Override
    @Step("Set Min Price: {0}")
    public DasvenebaPageSteps setMinPrice(Integer minPrice) {
        new ProductsAndServicesSteps().setMinPrice(minPrice);
        return this;
    }

    @Override
    @Step("Set Max Price: {0}")
    public DasvenebaPageSteps setMaxPrice(Integer maxPrice) {
        new ProductsAndServicesSteps().setMaxPrice(maxPrice);
        return this;
    }

    @Override
    @Step("Click on 'ძებნა' Button and Wait Until jQuery Requests Complete")
    public DasvenebaPageSteps clickOnDzebnaButton() {
        new ProductsAndServicesSteps().clickOnDzebnaButton();
        return this;
    }

    @Override
    @Step("add first returned item to favorites list")
    public DasvenebaPageSteps addFirstOfferToFavorites() {
        new ProductsAndServicesSteps().addFirstOfferToFavorites();
        return this;
    }

    @Override
    @Step("Sort By Price Decrease")
    public DasvenebaPageSteps selectSortByPriceDecrease() {
        new ProductsAndServicesSteps().selectSortByPriceDecrease();
        return this;
    }
}
