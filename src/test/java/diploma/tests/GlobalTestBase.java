package diploma.tests;

import diploma.config.CredentialsConfig;
import diploma.config.MobileConfig;
import diploma.tests.api.page.ZvetApiPage;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;

public class GlobalTestBase {
    public static ZvetApiPage zvetPage = new ZvetApiPage();
    public static CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class, System.getProperties());
    public static MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());
    public static String email = credentialsConfig.userEmail(),
            password = credentialsConfig.userPassword();

    @Step("Global web configuration")
    public static void globalConfigure() {
        RestAssured.baseURI = credentialsConfig.baseURI();
        zvetPage.getCookies();
        zvetPage.getToken();
        zvetPage.login(email, password);
    }
}
