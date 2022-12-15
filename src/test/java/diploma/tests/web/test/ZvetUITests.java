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

import java.util.stream.Stream;

@Tag("Web")
@Tag("All")
@Epic("MegaZvet")
@Feature("Web tests")
@Owner("Geraniya")
public class ZvetUITests extends WebTestBase {
    @ParameterizedTest(name = "Add bouquet {0} to basket")
    @Tag("Web")
    @DisplayName("Items in wishlist adding check")
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
    @ParameterizedTest(name = "Calculate total sum for {0} {1} with price {2} for {3} pieces")
    @Tag("Web")
    @DisplayName("Calculator counts correctly")
    @MethodSource
    void calculatorTest(String flower, String color, int price, int pack) {
        mainPage.openPage();
        mainPage.calculateFlowerPrice(flower, color, price, pack);
    }

    static Stream<Arguments> calculatorTest() {
        return Stream.of(
                Arguments.of("Гербера", "Малиновая", 149, 30),
                Arguments.of("Калла", "Белая", 199, 10),
                Arguments.of("Хризантема", "Карамельная", 299, 10)
        );
    }
}
