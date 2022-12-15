package diploma.tests.web.test;

import diploma.tests.web.base.WebTestBase;
import diploma.tests.web.dictionary.Flowers;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


@Tag("Web")
@Tag("All")
@Epic("MegaZvet")
@Feature("Web tests")
@Owner("Geraniya")
public class BasketTests extends WebTestBase {
    @ParameterizedTest(name = "Add bouquet {0} to basket")
    @Tag("Web")
    @DisplayName("Items in basket adding check")
    @EnumSource(Flowers.class)
    void addItemToCartFromMainTest(Flowers flowers) {
        mainPage.openPage();
        mainPage.addToCart(flowers.getProductName());
        basketPage.isFlowerExistsInBasket(flowers.getProductName());
    }
    @Test()
    @Tag("Web")
    @DisplayName("Check continue button in empty basket")
    void continueInEmptyBasketTest() {
        basketPage.openPage();
        basketPage.checkEmptyBasket();
    }
}
