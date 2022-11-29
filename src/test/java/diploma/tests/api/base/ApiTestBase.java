package diploma.tests.api.base;

import diploma.config.ZvetConfigProvider;
import diploma.tests.GlobalTestBase;
import diploma.tests.api.page.AccountApiPage;
import diploma.tests.api.page.BasketApiPage;
import diploma.tests.api.page.WishListApiPage;
import diploma.tests.api.page.ZvetApiPage;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static diploma.config.ZvetConfigProvider.zvetConfig;

public class ApiTestBase extends GlobalTestBase {
    public AccountApiPage accountApiPage = new AccountApiPage();
    public WishListApiPage wishListApiPage = new WishListApiPage();
    public BasketApiPage basketApiPage = new BasketApiPage();
    @BeforeAll
    @Step("Browser configuration")
    static void configure() {
        globalConfigure();
    }
}
