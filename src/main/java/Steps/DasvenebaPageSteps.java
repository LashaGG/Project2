package Steps;

import Pages.DasvenebaPageObject;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class DasvenebaPageSteps implements IProductsAndServicesSteps {
    public DasvenebaPageObject page = new DasvenebaPageObject();

    @Step
    public DasvenebaPageSteps clickOnMtisKurortiCategory() {
        page.mtisKurortiCategory.scrollIntoView(false).click();
        return this;
    }

    @Override//Step ანოტაციები არ გავუწერე, რაგდან  ProductsAndServicesSteps() მეთოდებს
    // უკვე აქვთ ანოტაციები და Allure report-ში 2-ჯერ გამოჩნდებოდა Step ანოტაცია
    public DasvenebaPageSteps clickOnProduct(int index) {
        new ProductsAndServicesSteps().clickOnProduct(index);
        return this;
    }

    @Override
    public DasvenebaPageSteps setMinPrice(Integer minPrice) {
        new ProductsAndServicesSteps().setMinPrice(minPrice);
        return this;
    }

    @Override
    public DasvenebaPageSteps setMaxPrice(Integer maxPrice) {
        new ProductsAndServicesSteps().setMaxPrice(maxPrice);
        return this;
    }

    @Override
    public DasvenebaPageSteps clickOnDzebnaButton() {
        new ProductsAndServicesSteps().clickOnDzebnaButton();
        return this;
    }

    @Override
    public DasvenebaPageSteps addFirstOfferToFavorites() {
        new ProductsAndServicesSteps().addFirstOfferToFavorites();
        return this;
    }

    @Override
    public DasvenebaPageSteps selectSortByPriceDecrease() {
        new ProductsAndServicesSteps().selectSortByPriceDecrease();
        return this;
    }
}
