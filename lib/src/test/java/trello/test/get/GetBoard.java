package trello.test.get;

import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import trello.test.RequestManager;

import static io.restassured.RestAssured.given;

public class GetBoard {

    String id;
    @Before
    public void createBoard(){
        id = RequestManager.post("/1/boards","{\"name\":\"Create Board LF\"}" ).path("id");
    }

    @After
    public void deleteB(){
        RequestManager.delete("/1/boards/" + id);
    }

    @Test
    public void getBoard(){
        Response response = RequestManager.get("/1/boards/" + id);
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("Create Board LF", response.body().path("name"));
    }
}
