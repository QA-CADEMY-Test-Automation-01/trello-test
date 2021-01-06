package trello.test.cucumber;

import io.restassured.response.Response;
import trello.test.Board;

import java.util.HashMap;
import java.util.Map;

public class Helper {

    Response response;
    HashMap<String, Object> context;

    public Helper(){
        context = new HashMap<>();
    }
}
