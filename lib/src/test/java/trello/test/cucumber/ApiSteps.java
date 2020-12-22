package trello.test.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import trello.test.RequestManager;

public class ApiSteps {

    private String endPoint;
    private Response response;

    @Given("I have the Endpoint {string}")
    public void i_have_the_endpoint(String endPoint) {
        this.endPoint = endPoint;
    }

    @When("I send a {string} request")
    public void i_send_a_request(String method) {
        response = RequestManager.get(endPoint);
    }

    @Then("I expect {int} as status code")
    public void i_expect_as_status_code(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }

}
