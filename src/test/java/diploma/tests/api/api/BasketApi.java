package diploma.tests.api.api;

import diploma.tests.GlobalTestAuthorization;
import diploma.tests.api.models.AddToBasketResponseModel;
import diploma.tests.api.models.Product;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.stream.Stream;

import static diploma.tests.api.specs.Specs.getCookieRequest;
import static diploma.tests.api.specs.Specs.response;
import static io.restassured.RestAssured.given;

public class BasketApi {
    private GlobalTestAuthorization globalTestAuthorization = GlobalTestAuthorization.getInstance();

    @Step("Add item in Basket")
    public AddToBasketResponseModel addItem(String item) {
            return given()
                    .spec(getCookieRequest(globalTestAuthorization.getAllDetailedCookies()))
                    .contentType(ContentType.URLENC)
                    .header("x-requested-with", "XMLHttpRequest")
                    .header("x-xsrf-token", globalTestAuthorization.getCorrectXsrfToken())
                    .body("product_id=" + item + "&quantity=1")
                    .when()
                    .post("/basket/add")
                    .then()
                    .spec(response)
                    .extract()
                    .as(AddToBasketResponseModel.class);
    }

    static Stream<Arguments> addItemsInBasket() {
        return Stream.of(
                Arguments.of("9489", new Product("0009489", "Новогодний букет \\\"Красный\\\" в стаканчике", 1, "Букеты", 1199)),
                Arguments.of("908", new Product("0000908", "Букет \\\"С Днем Рождения\\\" мини", 1, "Букеты", 3199)),
                Arguments.of("2572", new Product("0002572", "Букет \\\"Белые Розы и Альстромерии\\\" в коробке", 1, "Букеты", 3299))
        );
    }
}
