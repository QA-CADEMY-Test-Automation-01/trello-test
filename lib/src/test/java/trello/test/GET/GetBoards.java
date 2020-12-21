package trello.test.GET;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import trello.test.Autentication;
import trello.test.RequestManager;

import static io.restassured.RestAssured.given;

public class GetBoards {
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    String userId = "";


    public GetBoards() {

        requestSpecification = new Autentication().getRequestSpecification();
    }

    @Before
    public void createUser(){

        userId = given().
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
                delete("/public-api/users/{id}", userId).
                then().statusCode(200);
    }



    @Test
    public void getBoard(){
        Response response = RequestManager.get("/public-api/users/" + userId);
        Assert.assertEquals(200, response.getStatusCode());
    }
}
