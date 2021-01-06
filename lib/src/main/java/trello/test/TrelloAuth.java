package trello.test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TrelloAuth {

    private static final String BASE_URL = "https://api.trello.com";
    private static final String KEY = "013fb1d80492537963ac96f2ec4eaf83";
    private static final String TOKEN = "3da9a29af840e034223fef312e0123d43b70c6bd9d149adc4df4e4374e79bafa";

    private RequestSpecification requestSpecification;

    public TrelloAuth(){
        requestSpecification = new RequestSpecBuilder().
                setBaseUri(BASE_URL).
                addQueryParam("key", KEY).
                addQueryParam("token", TOKEN ).
                addHeader("Content-Type", "application/json").
                build();
    }

    public RequestSpecification getRequestSpecification(){
        return requestSpecification;
    }

}
