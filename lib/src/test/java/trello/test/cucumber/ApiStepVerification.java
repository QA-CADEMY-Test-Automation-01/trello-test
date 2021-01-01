package trello.test.cucumber;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ApiStepVerification {

    Helper helper;
    public ApiStepVerification(Helper helper){
        this.helper = helper;
    }

    @Then("I expect {int} as status code")
    public void i_expect_as_status_code(int statusCode) {
        Assert.assertEquals(helper.response.statusCode(), statusCode);
    }
}
