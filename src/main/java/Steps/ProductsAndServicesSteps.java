package Steps;

import Pages.ProductsAndServicesPageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;

public class ProductsAndServicesSteps implements IProductsAndServicesSteps {


    public ProductsAndServicesPageObject page = new ProductsAndServicesPageObject();

    private void waitUntilJQueryIsActive() {
        Selenide.Wait().until(webDriver -> {
            return (Boolean) ((JavascriptExecutor) webDriver)
                    .executeScript("return jQuery.active == 0");
        });
    }

    @Step("Click on Prdouct N:{0}")
    public ProductsAndServicesSteps clickOnProduct(int index) {
        page.specialOffersList.get(index).scrollIntoView(false).click();
        return this;
    }


    @Step("Set Min Price: {0}")
    public ProductsAndServicesSteps setMinPrice(Integer minPrice) {
        page.minPriceInput.scrollIntoView(false).sendKeys(minPrice.toString());
        return this;
    }

    @Step("Set Max Price: {0}")
    public ProductsAndServicesSteps setMaxPrice(Integer maxPrice) {
        page.maxPriceInput.scrollIntoView(false).sendKeys(maxPrice.toString());
        return this;
    }

    @Step("Click on 'ძებნა' Button and Wait Until jQuery Requests Complete")
    public ProductsAndServicesSteps clickOnDzebnaButton() {
        Selenide.executeJavaScript("arguments[0].click()", page.dzebnaButton.shouldHave(Condition.exist));
        waitUntilJQueryIsActive();
        return this;
    }

    @Step("add first returned item to favorites list")
    public ProductsAndServicesSteps addFirstOfferToFavorites() {
        var offer = page.specialOffersList.get(0);
        offer.$(".dis-price").click();
        return this;
    }

    @Step("Sort By Price Decrease")
    public ProductsAndServicesSteps selectSortByPriceDecrease() {
        page.sortSelect.selectOptionContainingText("ფასით კლებადი");
        waitUntilJQueryIsActive();
        return this;
    }


}
