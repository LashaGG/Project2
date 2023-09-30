package Steps;

import Pages.SwoopGeMainPage;
import io.qameta.allure.Step;

public class MainPageSteps {
    SwoopGeMainPage page;

    public MainPageSteps() {
        page = new SwoopGeMainPage();
    }

    @Step("clicks on დასვენება button on Header")
    public MainPageSteps clickOnDasvenebaButton() {
        page.dasvenebaButton.scrollTo().click();
        return this;
    }

    @Step("clicks on კვება button on Header")
    public MainPageSteps clickOnKvebaButton() {
        page.kvebaButton.scrollTo().click();
        return this;
    }

    @Step("Accept Cookies")
    public MainPageSteps acceptCookies() {
        page.acceptCookiesButton.click();
        return this;
    }


}
