package trello.test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GoRestTest {

    int newuserID;

    private RequestSpecification requestSpecification;

    public  GoRestTest() {
        requestSpecification = new RequestSpecBuilder().
                setBaseUri("https://gorest.co.in").
                addHeader("Authorization", "Bearer ee74c94191ca177aefa1a9eb7e2b538cf6e886cd4763095bf7d4e89b5bc631fb").
                addHeader("Content-Type", "application/json").
                build();
    }

//    @Test
//    public void GetUsers(){
//        given().spec(requestSpecification).
//                when().log().all().
//                get("/public-api/users").
//                then().log().all().
//                assertThat().statusCode(200);
//    }

    @Test
    public void PostUser(){
        newuserID = given().spec(requestSpecification).
                body("{\"name\":\"Tenali Ramakrishna\", \"gender\":\"Male\", \"email\":\"tenali.dd@15ce.com\", \"status\":\"Active\"}").
                when().log().all().
                post("/public-api/users").
                then().log().all().
                assertThat().statusCode(200).extract().response().path("data.id");
    }

    @Test
    public void GetUser(){
        String response = given().spec(requestSpecification).log().all().
                when().
                get("/public-api/users/{id}", newuserID).
                then().extract().response().path("data.email");
        Assert.assertEquals("tenali.dd@15ce.com" , response);
    }
}
