package diploma.tests.api.api;

import com.github.javafaker.Faker;
import diploma.tests.GlobalTestAuthorization;
import diploma.tests.api.models.AddToWishListResponseModel;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

import static diploma.tests.api.specs.Specs.*;
import static io.restassured.RestAssured.given;

public class WishListApi {
    private GlobalTestAuthorization globalTestAuthorization = GlobalTestAuthorization.getInstance();
    private Faker faker = new Faker();
    private int addedItems = 0;
    private ArrayList<String> itemsToDelete;

    @Step("Try to add item in WishList")
    public WishListApi tryToAddRandomItemAndCountSuccessfullyAdded() {
        try {
            AddToWishListResponseModel responseModel = given()
                    .spec(getCookieRequest(globalTestAuthorization.getAllDetailedCookies()))
                    .contentType(ContentType.URLENC)
                    .queryParam("route", "account/wishlist/add")
                    .header("x-requested-with", "XMLHttpRequest")
                    .header("x-xsrf-token", globalTestAuthorization.getCorrectXsrfToken())
                    .body("product_id=" + faker.number().numberBetween(9000, 9999))
                    .when()
                    .post("/index.php")
                    .then()
                    .spec(response)
                    .extract()
                    .as(AddToWishListResponseModel.class);
            if (!responseModel.getSuccess().equals("")) {
                addedItems++;
            }
        } catch (RuntimeException e) {
            System.out.println("No such element");
        }
        return this;
    }

    @Step("Open wishlist and count added items")
    public int countActualItems() {
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

    @Step("Open wishlist and get item list to be deleted")
    public WishListApi addItemsToDeletionList() {
        setItemsToDelete(getItemsFromBody(given()
                .spec(getCookieRequest(globalTestAuthorization.getAllDetailedCookies()))
                .when()
                .get("/wishlist/")
                .then()
                .spec(response)
                .extract().body().asPrettyString()));
        return this;
    }

    @Step("Remove all items from wishlist")
    public WishListApi deleteAllItems() {
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
