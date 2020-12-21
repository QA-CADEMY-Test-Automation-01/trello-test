package trello.test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.function.ToDoubleBiFunction;

public class Autentication {
    private static final String BASE_URL = "https://gorest.co.in";
    private static final String TOKEN = "Bearer ee74c94191ca177aefa1a9eb7e2b538cf6e886cd4763095bf7d4e89b5bc631fb";

    private RequestSpecification requestSpecification;

    public Autentication(){
        requestSpecification = new RequestSpecBuilder().
                setBaseUri(BASE_URL).
                addHeader("Authorization", TOKEN).
                addHeader("Content-Type", "application/json").
                build();
    }

    public RequestSpecification getRequestSpecification(){
        return requestSpecification;
    }
}
