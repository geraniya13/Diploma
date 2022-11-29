package diploma.tests.api.test;

import diploma.tests.api.models.AddToBasketResponseModel;
import diploma.tests.api.models.Product;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import diploma.tests.api.base.ApiTestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Api")
@Tag("All")
@Epic("MegaZvet")
@Feature("Api tests")
@Owner("Geraniya")
public class ZvetApiTests extends ApiTestBase {
    @Tag("Api")
    @AllureId("101")
    @DisplayName("User name is changed properly")
    @Test
    public void changeUserNameTest() {
        step("Open personal info edit page", () -> {
            accountApiPage.openEditAccountPage();
        });
        step("Check if name was changed", () -> {
            accountApiPage.changeUserName();
            assertThat(accountApiPage.getCurrentUserName()).doesNotContain(accountApiPage.getUserBodyModel().getFirstname());
        });
    }

    @Tag("Api")
    @AllureId("102")
    @DisplayName("Items are added in wishlist properly")
    @Test
    public void addItemsInWishListTest() {
        step("Try to add random items in wishlist", () -> {
            for (int i = 0; i < 3; i++) {
                wishListApiPage.addToWishList();
            }
        });
        step("Check if all available items were added", () -> {
            assertEquals(wishListApiPage.getAddedItems(), wishListApiPage.openWishListAndCountItems());
        });
        step("Clear wishlist", () -> {
            wishListApiPage.deleteItemsFromWishList();
        });
    }

    @Tag("Api")
    @AllureId("103")
    @MethodSource("addItemsInBasket")
    @ParameterizedTest(name = "Item with product_id = {0} is added in basket properly")
    public void addItemsInBasket(String productId, Product product) {
        step("Add item in basket and check it was successful", () -> {
            AddToBasketResponseModel response = basketApiPage.addToBasket(productId);
            assertThat(response.isSuccess()).isTrue();
            assertEquals(response.getEcommerce().getProducts().get(0).getQuantity(), product.getQuantity());
            assertEquals(response.getEcommerce().getProducts().get(0).getId(), product.getId());
        });
    }

    static Stream<Arguments> addItemsInBasket() {
        return Stream.of(
                Arguments.of("9489", new Product("0009489", "Новогодний букет \\\"Красный\\\" в стаканчике", 1, "Букеты", 1199)),
                Arguments.of("908", new Product("0000908", "Букет \\\"С Днем Рождения\\\" мини", 1, "Букеты", 3199)),
                Arguments.of("2572", new Product("0002572", "Букет \\\"Белые Розы и Альстромерии\\\" в коробке", 1, "Букеты", 3299))
        );
    }
}
