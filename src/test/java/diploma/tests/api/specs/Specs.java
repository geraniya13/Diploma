package diploma.tests.api.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static diploma.helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;

public class Specs {

    public static RequestSpecification request = with()
            .filter(withCustomTemplates())
            .log().all()
            .baseUri(baseURI);

    public static RequestSpecification getCookieRequest(Cookies cookies) {
        return new RequestSpecBuilder().addFilter(withCustomTemplates()).log(ALL).setBaseUri(baseURI).addCookies(cookies).build();
    }


    public static ResponseSpecification response = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
            .build();

    public static ResponseSpecification redirectedResponse = new ResponseSpecBuilder()
            .expectStatusCode(302)
            .log(ALL)
            .build();
}
