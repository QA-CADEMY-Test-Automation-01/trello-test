package trello.test.cucumber;

import com.sun.tools.jconsole.JConsoleContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.junit.runner.Request;
import trello.test.Board;
import trello.test.RequestManager;

public class Hooks {

    Helper helper;
    public Hooks(Helper helper){
        this.helper = helper;
    }

    @Before("@createBoard")
    public void createBoard(){
        Response resp = RequestManager.post("/1/boards","{\"name\":\"test bor\"}" );
        helper.context.put("board",resp);
    }


    @After("@createBoard")
    public  void deleteBoard() {
        Response response = (Response) helper.context.get("board");
        RequestManager.delete("/1/boards/" + response.jsonPath().getString("id"));
    }

}
