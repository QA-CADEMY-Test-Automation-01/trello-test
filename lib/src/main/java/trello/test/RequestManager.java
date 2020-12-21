package trello.test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public final class RequestManager {

    private static RequestSpecification requestSpecification = new Autentication().getRequestSpecification();

    public static Response get(String endpoint){
        return given()
                .spec(requestSpecification).
        when().get(endpoint);
    }

    public static Response post(String endpoint, String body){
        return given().
                spec(requestSpecification).
                body(body).
                when().post(endpoint);
    }
}
