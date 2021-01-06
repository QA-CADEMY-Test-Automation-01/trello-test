package trello.test.get;

import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import trello.test.Board;
import trello.test.RequestManager;

import static io.restassured.RestAssured.given;

public class GetBoard {

    Board board;
    @Before
    public void createBoard(){
        board = RequestManager.post("/1/boards","{\"name\":\"Create Board LF\"}" ).as(Board.class);
    }

    @After
    public void deleteB(){
        RequestManager.delete("/1/boards/" + board.getId());
    }

    @Test
    public void getBoard(){
        Response response = RequestManager.get("/1/boards/" + board.getId());
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("Create Board LF", response.body().path("name"));
    }
}
