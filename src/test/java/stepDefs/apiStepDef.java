package stepDefs;

import io.cucumber.java.en.*;
import pages.ApiPage;

public class apiStepDef {
    ApiPage apiPage;
    public apiStepDef() {
        this.apiPage = new ApiPage();
    }
    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.prepareUrl(url);
    }
    @And("hit api get list users")
    public void hitApiGetListUsers() {
        apiPage.hitApiGetListUsers();
    }
    @Then("validate status code is equal {int}")
    public void validateStatusCodeIsEqual(int status_code) {
        apiPage.validateStatusCode(status_code);
    }
    @Then("validate response body get list users")
    public void validateResponseBodyGetListUsers() {
        apiPage.validateResponseGetList();
    }
    @Then("validate response json schema {string}")
    public void validateResponseJsonSchema(String filename) {
        apiPage.validateResponseJsonSchema(filename);
    }


    @And("hit api post create new user")
    public void hitApiPostCreateNewUser() {
        apiPage.hitApiPostCreateUser();
    }
    @Then("validate response body post create user")
    public void validateResponseBodyPostCreateUser() {
        apiPage.validateResponsePostCreate();
    }

    @And("hit api put update user data")
    public void hitApiPutUpdateUserData() {
        apiPage.hitApiPutUpdateUser();
    }
    @Then("validate response body put update user")
    public void validateResponseBodyPutUpdateUser() {
        apiPage.validateResponsePutUpdate();
    }


    @Given("hit api delete user data")
    public void hitApiDeleteUserData() {
        apiPage.hitApiDeleteUser();
    }
}
