package trello.test.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import trello.test.RequestManager;

public class ApiSteps {

    private String endPoint;
    private Helper helper;
    private String body;

    public ApiSteps (Helper helper){
        this.helper = helper;
    }

    @Given("I have the Endpoint {string}")
    public void i_have_the_endpoint(String endPoint) {
        String endpo  = Utils.buildEndpoind(helper, endPoint);
        this.endPoint = endpo;
    }

    @When("I send a {string} request")
    public void i_send_a_request(String method) {
        if(method.equals("POST")){
            this.helper.response = RequestManager.post(this.endPoint, this.body);
        }
        if(method.equals("GET")){
            this.helper.response = RequestManager.get(this.endPoint);
        }

    }

    @And("I set body")
    public void iSetBody(String body) {
        this.body = Utils.buildBody(helper, body);
    }
}
