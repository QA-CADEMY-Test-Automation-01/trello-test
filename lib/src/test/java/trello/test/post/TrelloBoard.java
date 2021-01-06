package trello.test.post;

import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import trello.test.RequestManager;

public class TrelloBoard {
    String id;

    @After
    public void deleteB(){
        RequestManager.delete("/1/boards/" + id);
    }

    @Test
    public void createBoard(){
        Response res = RequestManager.post("/1/boards/","{\"name\":\"New Board\"}" );
        id = res.body().path("id");
        Assert.assertEquals(res.statusCode(), 200);
    }
}
