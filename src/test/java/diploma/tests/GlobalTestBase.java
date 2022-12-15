package diploma.tests;

import diploma.config.CredentialsConfig;
import diploma.config.MobileConfig;
import diploma.tests.api.api.AuthorizationApi;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;

public class GlobalTestBase {
    public static AuthorizationApi authApi = new AuthorizationApi();
    public static CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class, System.getProperties());
    public static MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());
    public static String email = credentialsConfig.userEmail(),
            password = credentialsConfig.userPassword();

    @Step("Global web configuration")
    public static void globalConfigure() {
        RestAssured.baseURI = credentialsConfig.baseURI();
        authApi.getCookies();
        authApi.getToken();
        authApi.login(email, password);
    }
}
