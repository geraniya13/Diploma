package diploma.tests.api.base;

import diploma.tests.GlobalTestBase;
import diploma.tests.api.api.AccountApi;
import diploma.tests.api.api.BasketApi;
import diploma.tests.api.api.WishListApi;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase extends GlobalTestBase {
    public AccountApi accountApi = new AccountApi();
    public WishListApi wishListApi = new WishListApi();
    public BasketApi basketApi = new BasketApi();
    @BeforeAll
    @Step("Browser configuration")
    static void configure() {
        globalConfigure();
    }
}
