package Steps;

import Pages.HeaderPage;
import io.qameta.allure.Step;

public class HeaderPageSteps {
    HeaderPage page;

    public HeaderPageSteps() {
        page = new HeaderPage();
    }

    @Step("Accept Cookies")
    public HeaderPageSteps acceptCookies() {
        page.acceptCookiesButton.click();
        return this;
    }

    @Step("clicks on დასვენება button on Header")
    public DasvenebaPageSteps clickOnDasvenebaButton() {
        page.dasvenebaButton.click();
        return new DasvenebaPageSteps();
    }

    @Step("clicks on კვება button on Header")
    public KvebaDefaultPageSteps clickOnKvebaButton() {
        page.kvebaButton.click();
        return new KvebaDefaultPageSteps();
    }

    @Step("clicks on categories arrow on Header")
    public HeaderPageSteps clickOnCategoriesArrow() {
        page.categoiresArrow.click();
        return this;
    }

    @Step("Hover 'კვება' category")
    public HeaderPageSteps hoverKvebaCategory() {
        page.kvebaCategory.hover();
        return this;
    }


    @Step("click on sushi Subcategory")
    public HeaderPageSteps clickOnSusiSubcategory() {
        page.sushiSubcategory.click();
        return this;
    }


}
