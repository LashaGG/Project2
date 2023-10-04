package Steps;

import Pages.ProductPageObject;
import io.qameta.allure.Step;

public class ProductSteps {

    public ProductPageObject page = new ProductPageObject();

    @Step("Share Page")
    public ProductSteps clickOnShareButton() {
        page.shareButton.scrollIntoView(false).click();
        return this;
    }

    @Step("Checkout")
    public ProductSteps clickOnCheckoutButton() {
        page.checkoutButton.scrollIntoView(false).click();
        return this;
    }


}
