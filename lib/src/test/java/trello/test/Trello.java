package trello.test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Trello {
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    public Trello() {
        requestSpecification = new RequestSpecBuilder().
                setBaseUri("https://api.trello.com").
                addHeader("Content-Type", "application/json").
                addQueryParam("key", "013fb1d80492537963ac96f2ec4eaf83").
                addQueryParam("token", "3da9a29af840e034223fef312e0123d43b70c6bd9d149adc4df4e4374e79bafa").
                build();

        responseSpecification = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }

    @Test
    public void testTrelloBoardsGetMethod() {
        given().
                spec(requestSpecification).
                log().all().
                when().
                get("/1/members/me/boards").
                then().
                log().all().
                spec(responseSpecification);
    }

    @Test
    public void testTrelloBoardsPostMethod() {
        given().
                spec(requestSpecification).
                body("{\"name\":\"Example Boardd\"}").
                log().all().
                when().
                post("/1/boards").
                then().
                log().all().
                spec(responseSpecification).
                assertThat().
                body("name", equalTo("Example Board"));
    }

    @Test
    public void testTrelloBoardsPutMethod() {
        given().
                spec(requestSpecification).
                body("{\"name\":\"Renamed Example\"}").
                log().all().
                when().
                put("/1/boards/{id}","5f5426601f240e861780f51d").
                then().
                log().all().
                spec(responseSpecification);
    }

    @Test
    public void testTrelloBoardsDeleteMethod() {
        given().
                spec(requestSpecification).
                log().all().
                when().
                delete("/1/boards/{id}","5f5426601f240e861780f51d").
                then().
                log().all().
                spec(responseSpecification);
    }
}
