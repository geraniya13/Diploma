package diploma.tests.api.page;

import diploma.tests.GlobalTestAuthorization;
import diploma.tests.api.models.AddToBasketResponseModel;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

import static diploma.tests.api.specs.Specs.getCookieRequest;
import static diploma.tests.api.specs.Specs.response;
import static io.restassured.RestAssured.given;

public class BasketApiPage {
    private GlobalTestAuthorization globalTestAuthorization = GlobalTestAuthorization.getInstance();
    private int addedItems = 0;
    private ArrayList<String> itemsToDelete;

    @Step("Add item in Basket")
    public AddToBasketResponseModel addToBasket(String item) {
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

    @Step("Open wishlist and count added items")
    public int openWishListAndCountItems() {
        String responseBody = given()
                .spec(getCookieRequest(globalTestAuthorization.getAllDetailedCookies()))
                .when()
                .get("/wishlist/")
                .then()
                .spec(response)
                .extract().body().asPrettyString();
        setItemsToDelete(getItemsFromBody(responseBody));
        return getItemsCountFromBody(responseBody);
    }

    @Step("Remove all items from wishlist")
    public BasketApiPage deleteItemsFromWishList() {
        for (String item : getItemsToDelete()) {
            given()
                    .spec(getCookieRequest(globalTestAuthorization.getAllDetailedCookies()))
                    .queryParam("remove", item)
                    .when()
                    .get("/wishlist/")
                    .then()
                    .spec(response);
        }
        return this;
    }

    public int getAddedItems() {
        return addedItems;
    }

    public ArrayList<String> getItemsToDelete() {
        return itemsToDelete;
    }

    public void setItemsToDelete(ArrayList<String> itemsToDelete) {
        this.itemsToDelete = itemsToDelete;
    }

    public int getItemsCountFromBody(String body) {
        int count = 0;
        String[] contents = body.split("\n");
        for (String line : contents) {
            if (line.contains("wish-quantity")) {
                count = Integer.parseInt(StringUtils.substringBetween(line, "<span class=\"wish-quantity\">", "</span>"));
            }
        }
        return count;
    }

    public ArrayList<String> getItemsFromBody(String body) {
        ArrayList<String> values = new ArrayList<>();
        String[] contents = body.split("\n");
        for (String line : contents) {
            if (line.contains("wishlist/?remove=")) {
                values.add(StringUtils.substringBetween(line, "wishlist/?remove=", "\""));
            }
        }
        return values;
    }
}
