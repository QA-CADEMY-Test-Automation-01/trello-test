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
        helper.response= RequestManager.post("/1/boards","{\"name\":\"testAAA\"}" );
        helper.context.put("board",helper.response);
    }


    @After("@createBoard")
    public  void deleteBoard() {
        Response response = (Response) helper.context.get("board");
        RequestManager.delete("/1/boards/" + response.jsonPath().getString("id"));
    }

    @After("@otherTag")
    public  void deleteBoardB() {
        Response response = (Response) helper.context.get("B");
        RequestManager.delete("/1/boards/" + response.jsonPath().getString("id"));
    }

}
