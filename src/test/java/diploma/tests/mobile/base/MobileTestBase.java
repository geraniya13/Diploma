package diploma.tests.mobile.base;

import com.codeborne.selenide.Configuration;
import diploma.tests.mobile.drivers.BrowserstackMobileDriver;
import diploma.tests.mobile.drivers.LocalMobileDriver;
import diploma.tests.mobile.helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class MobileTestBase {
    private static String environment = System.getProperty("environment");
    @BeforeAll
    @Step("Mobile test configuration")
    public static void setup() throws Exception {
        switch (environment) {
            case "remote" -> {
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                Configuration.browserSize = null;
            }
            case "local" -> {
                Configuration.browser = LocalMobileDriver.class.getName();
                Configuration.browserSize = null;
            }
            default -> throw new Exception("Wrong environment");
        }
    }

    @BeforeEach
    @Step("Starting driver")
    public final void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    @Step("Get Attachments")
    public final void afterEach() {
        String sessionId = sessionId().toString();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
        if (environment.equals("remote")) {
            Attach.video(sessionId);
        } else {
            closeWebDriver();
        }
    }
}
