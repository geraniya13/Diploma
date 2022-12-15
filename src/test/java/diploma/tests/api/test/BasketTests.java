package diploma.tests.api.test;

import diploma.tests.api.models.AddToBasketResponseModel;
import diploma.tests.api.models.Product;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
public class BasketTests extends ApiTestBase {
    @ParameterizedTest(name = "Item with product_id = {0} is added in basket")
    @Tag("Api")
    @DisplayName("Items in basket adding check")
    @MethodSource("addItemsInBasket")
    public void addItemsInBasket(String productId, Product product) {
        step("Add item in basket and check it was successful", () -> {
            AddToBasketResponseModel response = basketApi.addItem(productId);
            assertThat(response.isSuccess()).isTrue();
            assertEquals(response.getEcommerce().getProducts().get(0).getQuantity(), product.getQuantity());
            assertEquals(response.getEcommerce().getProducts().get(0).getId(), product.getId());
        });
    }

    static Stream<Arguments> addItemsInBasket() {
        return Stream.of(
                Arguments.of("9489", new Product("0009489", "���������� ����� \\\"�������\\\" � ����������", 1, "������", 1199)),
                Arguments.of("908", new Product("0000908", "����� \\\"� ���� ��������\\\" ����", 1, "������", 3199)),
                Arguments.of("2572", new Product("0002572", "����� \\\"����� ���� � ������������\\\" � �������", 1, "������", 3299))
        );
    }
}