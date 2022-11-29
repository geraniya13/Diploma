package diploma.tests.mobile.helpers;

import io.qameta.allure.restassured.AllureRestAssured;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    public static String videoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .filter(new AllureRestAssured())
                .log().all()
                .auth().basic("geraniya_DtMyaQ", "QH5ACzzkNrZM4patHkxG")
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}