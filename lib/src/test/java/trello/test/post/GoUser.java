package trello.test.post;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.After;
import org.junit.Test;
import trello.test.Autentication;

import static io.restassured.RestAssured.given;

public class GoUser {
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    String boardId= "";


    public GoUser() {
        requestSpecification = new Autentication().getRequestSpecification();
    }

    @Test
    public void createUser(){
        boardId = given().
                spec(requestSpecification).
                body("{\"name\":\"Tenali Ramakrishna\", \"gender\":\"Male\", \"email\":\"TennJhon@15ce.com\", \"status\":\"Active\"}").
                log().all().
                when().log().all().
                post("/public-api/users").
                then().extract().response().path("data.id").toString();
    }

    @After
    public void endTestCase(){
        given().
                spec(requestSpecification).
                when().
                delete("/public-api/users/{id}", boardId).
                then().statusCode(200);
    }
}
