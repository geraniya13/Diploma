package diploma.tests;

import diploma.config.GlobalConfig;
import diploma.config.MobileConfig;
import diploma.config.ZvetConfigProvider;
import diploma.tests.api.page.ZvetApiPage;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class GlobalTestBase {
    public static ZvetApiPage zvetPage = new ZvetApiPage();
    public static GlobalConfig globalConfig = ConfigFactory.create(GlobalConfig.class, System.getProperties());
    public static MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());
    public static String email = globalConfig.getUserEmail(),
            password = globalConfig.getUserPassword();

    @Step("Global web configuration")
    public static void globalConfigure() {
        RestAssured.baseURI = globalConfig.getBaseURI();
        zvetPage.getCookies();
        zvetPage.getToken();
        zvetPage.login(email, password);
    }
}
