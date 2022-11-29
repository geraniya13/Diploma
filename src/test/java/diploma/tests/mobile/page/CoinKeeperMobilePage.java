package diploma.tests.mobile.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static diploma.tests.mobile.elements.AuthorizationElements.*;
import static diploma.tests.mobile.elements.SnippetElements.*;

public class CoinKeeperMobilePage {

    @Step("Check first snippet page items")
    public void checkFirstSnippetPage() {
        snippetImage.shouldBe(visible);
        snippetTitle.shouldHave(text(firstSnippetTitleText));
        snippetText.shouldHave(text(firstSnippetTextValue));
        snippetSkipBtn.shouldHave(text(snippetSkipBtnText));
    }

    @Step("Check second snippet page items")
    public void checkSecondSnippetPage() {
        snippetImage.shouldBe(visible);
        snippetTitle.shouldHave(text(secondSnippetTitleText));
        snippetText.shouldHave(text(secondSnippetTextValue));
        snippetPremiumBtn.shouldHave(text(snippetDiscountBtnText));
    }

    @Step("Click on element {0}")
    public void clickOnElement(SelenideElement element) {
        element.click();
    }

    @Step("User authorization")
    public void userAuthorization(String login, String password) {
        emailInput.click();
        emailInput.sendKeys(login);
        passwordInput.click();
        passwordInput.sendKeys(password);
        clickOnElement(loginButton);
    }

    @Step("Check dialog text")
    public void checkDialogText(String text) {
        dialogMsg.shouldHave(text(text));

    }
}
