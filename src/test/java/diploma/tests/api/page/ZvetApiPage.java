package diploma.tests.api.page;

import diploma.tests.GlobalTestData;
import io.qameta.allure.Step;
import diploma.tests.api.models.LoginBodyModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static diploma.tests.api.specs.Specs.*;
import static io.restassured.config.RedirectConfig.redirectConfig;


public class ZvetApiPage {
    private GlobalTestData globalTestData = GlobalTestData.getInstance();

    @Step("Get cookies")
    public void getCookies() {
        Response response = given().spec(request).get("/");
        globalTestData.setAllDetailedCookies(response.getDetailedCookies());
    }

    @Step("Get authorisation token")
    public void getToken() {
        Response response = given().spec(getCookieRequest(globalTestData.getAllDetailedCookies())).get("/login/");
        globalTestData.setAuthorizeButtonToken(globalTestData.getInfoFromBody("_token", response.getBody().asPrettyString()));
    }

    @Step("Sign In")
    public ZvetApiPage login(String email, String password) {
        LoginBodyModel loginBodyModel = new LoginBodyModel();
        loginBodyModel.setToken(globalTestData.getAuthorizeButtonToken());
        loginBodyModel.setEmail(email);
        loginBodyModel.setPassword(password);
                given()
                        .config(RestAssured.config().redirect(redirectConfig().followRedirects(false)))
                        .spec(getCookieRequest(globalTestData.getAllDetailedCookies()))
                        .contentType(ContentType.URLENC)
                        .formParams(loginBodyModel.getFieldsAsMap())
                        .when()
                        .post("/login/")
                        .then()
                        .spec(redirectedResponse);
        return this;
    }
}
