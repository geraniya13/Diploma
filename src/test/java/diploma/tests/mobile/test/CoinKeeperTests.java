package diploma.tests.mobile.test;

import diploma.tests.mobile.base.MobileTestBase;
import diploma.tests.mobile.page.CoinKeeperMobilePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static diploma.tests.mobile.elements.AuthorizationElements.*;
import static diploma.tests.mobile.elements.SnippetElements.authorizeUserBtn;
import static diploma.tests.mobile.elements.SnippetElements.snippetSkipBtn;


@Tag("Mobile")
@Tag("All")
@Epic("Coinkeeper")
@Feature("Mobile tests")
@Owner("Geraniya")
public class CoinKeeperTests extends MobileTestBase {

    CoinKeeperMobilePage mobilePage = new CoinKeeperMobilePage();

    @Test
    @DisplayName("Snippet page test")
    void snippetPageContentTest() {
        mobilePage.checkFirstSnippetPage();
    }

    @Test
    @DisplayName("Skipping first snippet page test")
    void skipSnippetPageTest() {
        mobilePage.clickOnElement(snippetSkipBtn);
        mobilePage.checkSecondSnippetPage();
    }

    @Test
    @DisplayName("Invalid authorization test")
    void invalidAuthorizationTest() {
        mobilePage.clickOnElement(snippetSkipBtn);
        mobilePage.clickOnElement(authorizeUserBtn);
        mobilePage.userAuthorization(invalidEmail, invalidPassword);
        mobilePage.checkDialogText(invalidLoginMsgText);
    }

}
