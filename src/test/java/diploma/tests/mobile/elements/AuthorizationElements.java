package diploma.tests.mobile.elements;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationElements {

    public static String loginText = "Log In",
            invalidEmail = "mail",
            invalidPassword = "password",
            invalidLoginMsgText = "Please fill all fields";

    public static SelenideElement
            emailInput = $(AppiumBy.id("com.disrapp.coinkeeper.material:id/login_pass_edittext")),
            passwordInput = $(AppiumBy.id("com.disrapp.coinkeeper.material:id/login_pass_edittext")),
            loginButton = $(AppiumBy.id("com.disrapp.coinkeeper.material:id/login_button")),
            dialogMsg = $(AppiumBy.id("com.disrapp.coinkeeper.material:id/dialog_content_text_view"));
}
