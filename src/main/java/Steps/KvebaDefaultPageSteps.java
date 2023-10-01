package Steps;

import Pages.KvebaDefaultPage;
import io.qameta.allure.Step;

public class KvebaDefaultPageSteps {
    public KvebaDefaultPage page = new KvebaDefaultPage();

    @Step
    public KvebaDefaultPageSteps clickOnSusiSubcategory() {
        page.sushiCategory.scrollIntoView(false).click();
        return this;
    }

    @Step("add first returned item to favorites list")
    public KvebaDefaultPageSteps addFirstOfferToFavorites() {
        var offer = page.specialOffersList.get(0);
        offer.$(".dis-price").click();
        return this;
    }


}
