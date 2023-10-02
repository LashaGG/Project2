package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPageObject {

    public SelenideElement
            authorizationSection = $(".authorization"),
            fbAuthorization = $(".fb-authorization-p"),
            loginGmail = $(".login-gmail");


    public SelenideElement
            registrationSection = $(".register"),
            inputFirstName = $("#pFirstName"),
            inputLastName = $("#pLastName"),
            inputEmailName = $("#pEmail"),
            inputPhoneNumber = $("#pPhone"),
            inputDateBirth = $("#pDateBirth"),
            inputPassword = $("#pPassword"),
            inputConfirmPassword = $("#pConfirmPassword"),
            registerButton = $(".dashbord-registration").$("input"),
            physicalInfoMassage = $("#physicalInfoMassage");


}
