package diploma.tests.web.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import diploma.config.ZvetConfigProvider;
import diploma.tests.GlobalTestBase;
import diploma.tests.GlobalTestAuthorization;
import diploma.tests.web.pages.BasketPage;
import diploma.tests.web.pages.MainPage;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.http.Cookie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static diploma.helpers.Attach.*;
import static io.qameta.allure.Allure.step;


public class WebTestBase extends GlobalTestBase {
    public final MainPage mainPage = new MainPage();
    public final BasketPage basketPage = new BasketPage();
    private static final ZvetConfigProvider config = new ZvetConfigProvider();

    @BeforeAll
    @Step("Adjust browser settings")
    static void setup() {
        SelenideLogger.addListener("allureTest", new AllureSelenide());
        GlobalTestAuthorization globalTestAuthorization = GlobalTestAuthorization.getInstance();
        globalConfigure();
        Configuration.baseUrl = credentialsConfig.baseURI();
        config.setWebConfiguration();
        step("Open browser with lite contents", () ->
                open("/image/catalog/bouquet.svg"));

        step("Set cookies to browser", () -> {
            for (Cookie cookie : globalTestAuthorization.getAllDetailedCookies()) {
                getWebDriver().manage().addCookie(
                        new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue()));
            }
        });
    }

    @AfterEach
    @Step("Get Attachments")
    void getAttachments() {
        takeScreenshot();
        addSource();
        addHTMLSource();
        addBrowserConsoleLog();
        if (config.isRemote())
            addVideo();
    }
}
