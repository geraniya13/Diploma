package diploma.tests.api.page;

import com.github.javafaker.Faker;
import diploma.tests.GlobalTestAuthorization;
import diploma.tests.api.models.UserBodyModel;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static diploma.tests.api.specs.Specs.*;
import static io.restassured.RestAssured.given;

public class AccountApiPage {
    private GlobalTestAuthorization globalTestAuthorization = GlobalTestAuthorization.getInstance();
    private UserBodyModel userBodyModel = new UserBodyModel();
    private Faker faker = new Faker();

    @Step("Get current user name and change button token")
    public AccountApiPage openEditAccountPage() {
        Response response = given().spec(getCookieRequest(globalTestAuthorization.getAllDetailedCookies())).get("/edit-account/");
        userBodyModel.setToken(userBodyModel.getInfoFromBody("_token", response.getBody().asPrettyString()));
        userBodyModel.setFirstname(userBodyModel.getInfoFromBody("firstname", response.getBody().asPrettyString()));
        userBodyModel.setLastname(userBodyModel.getInfoFromBody("lastname", response.getBody().asPrettyString()));
        userBodyModel.setEmail(userBodyModel.getInfoFromBody("email", response.getBody().asPrettyString()));
        userBodyModel.setTelephone(userBodyModel.getInfoFromBody("telephone", response.getBody().asPrettyString()));
        userBodyModel.setFax(userBodyModel.getInfoFromBody("fax", response.getBody().asPrettyString()));
        return this;
    }

    @Step("Change user name")
    public AccountApiPage changeUserName() {
        given()
                .spec(getCookieRequest(globalTestAuthorization.getAllDetailedCookies()))
                .contentType(ContentType.URLENC)
                .formParams(userBodyModel.getFieldsAsMap(faker.name().firstName()))
                .when()
            //    .redirects().follow(true)
                .post("/edit-account/")
                .then()
                .spec(redirectedResponse);
        return this;
     //           .body().htmlPath().getString("html.body.div[5].div[2].div.div.div[1].div[1].div.p[1]");
    }

    @Step("Open User Account Page")
    public String getCurrentUserName() {
        return given()
                .spec(getCookieRequest(globalTestAuthorization.getAllDetailedCookies()))
                .contentType(ContentType.URLENC)
                .formParams(userBodyModel.getFieldsAsMap(faker.name().firstName()))
                .when()
                .get("/my-account/")
                .then()
                .spec(response)
                .extract()
                .body().htmlPath().getString("html.body.div[5].div[2].div.div.div[1].div[1].div.p[1]");
    }

    public UserBodyModel getUserBodyModel() {
        return userBodyModel;
    }
}
