package Steps;

import Pages.DasvenebaPageObject;

import static com.codeborne.selenide.Selenide.$;

public class DasvenebaPageSteps extends CommonPartSteps {
    public DasvenebaPageObject page = new DasvenebaPageObject();

    @Override
    public DasvenebaPageSteps setMinPrice(Integer minPrice) {
        super.setMinPrice(minPrice);
        return new DasvenebaPageSteps();
    }

    @Override
    public DasvenebaPageSteps setMaxPrice(Integer maxPrice) {
        super.setMaxPrice(maxPrice);
        return new DasvenebaPageSteps();
    }

    @Override
    public DasvenebaPageSteps clickOnDzebnaButton() {
        super.clickOnDzebnaButton();
        return new DasvenebaPageSteps();
    }

    @Override
    public DasvenebaPageSteps addFirstOfferToFavorites() {
        super.addFirstOfferToFavorites();
        return new DasvenebaPageSteps();
    }
}
