package Steps;

import Pages.LoginPageObject;
import io.qameta.allure.Step;

public class LoginPageSteps {

    public LoginPageObject page = new LoginPageObject();

    @Step("Select Authorization Section")
    public LoginPageSteps clickAuthorization() {
        page.authorizationSection.click();
        return this;
    }

    @Step("Select Registration Section")
    public LoginPageSteps clickRegistration() {
        page.registrationSection.click();
        return this;
    }

    @Step
    public LoginPageSteps clickFbAuthorization() {
        page.fbAuthorization.click();
        return this;
    }

    @Step
    public LoginPageSteps clickLoginWithGmail() {
        page.loginGmail.click();
        return this;
    }


    @Step("Enter FirstName: {0} ")
    public LoginPageSteps enterFirstName(String firstName) {
        page.inputFirstName.sendKeys(firstName);
        return this;
    }

    @Step("Enter LastName: {0} ")
    public LoginPageSteps enterLastName(String lastName) {
        page.inputLastName.sendKeys(lastName);
        return this;
    }

    @Step("Enter Email: {0} ")
    public LoginPageSteps enterEmail(String email) {
        page.inputEmailName.sendKeys(email);
        return this;
    }

    @Step("Enter Phone Number: {0} ")
    public LoginPageSteps enterPhoneNumber(String phoneNumber) {
        page.inputPhoneNumber.sendKeys(phoneNumber);
        return this;
    }

    @Step("Enter Date Of Birth: {0} ")
    public LoginPageSteps enterDateOfBirth(String dateOfBirth) {
        page.inputDateBirth.sendKeys(dateOfBirth);
        return this;
    }

    @Step("Enter Password: {0} ")
    public LoginPageSteps enterPassword(String password) {
        page.inputPassword.sendKeys(password);
        return this;
    }

    @Step("Confirm Password: {0} ")
    public LoginPageSteps enterConfirmPassword(String confirmPassword) {
        page.inputConfirmPassword.sendKeys(confirmPassword);
        return this;
    }

    @Step("Click on Register Button")
    public LoginPageSteps clickOnRegisterButton() {
        page.registerButton.scrollIntoView(false).click();
        return this;
    }


}
