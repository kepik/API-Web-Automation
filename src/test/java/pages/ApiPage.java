package pages;

import helpers.Endpoint;
import helpers.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.File;
import static helpers.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {
    String setUrl, global_id;
    Response res;
    public void prepareUrl(String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setUrl = Endpoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USER":
                setUrl = Endpoint.CREATE_NEW_USER;
                break;
            case "UPDATE_USER_DATA":
                setUrl = Endpoint.UPDATE_USER_DATA;
                break;
            case "DELETE_USER":
                setUrl = Endpoint.DELETE_USER;
                break;
            case "GET_LIST_TAG":
                setUrl = Endpoint.GET_LIST_TAG;
                break;
            default:
                System.out.println("input correct url");
        }
    }

    public void hitApiGetListUsers() {
        res = getListUsers(setUrl);
    }
    public void validateStatusCode(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }
    public void validateResponseGetList() {
        String id = res.jsonPath().get("data[0].id");
        String title = res.jsonPath().get("data[0].title");
        String firstName = res.jsonPath().get("data[0].firstName");
        String lastName = res.jsonPath().get("data[0].lastName");
        String picture = res.jsonPath().get("data[0].picture");

        assertThat(id).isNotNull();
        assertThat(title).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(picture).isNotNull();
    }
    public void validateResponseJsonSchema(String filename){
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void hitApiPostCreateUser() {
        res = postCreateUser(setUrl);
    }
    public void validateResponsePostCreate() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");
        String registerDate = jsonPathEvaluator.get("registerDate");
        String updatedDate = jsonPathEvaluator.get("updatedDate");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
        assertThat(registerDate).isNotNull();
        assertThat(updatedDate).isNotNull();

        global_id = id;
    }

    public void hitApiPutUpdateUser() {
        res = putUpdateUser(setUrl, global_id);
    }
    public void validateResponsePutUpdate() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");
        String registerDate = jsonPathEvaluator.get("registerDate");
        String updatedDate = jsonPathEvaluator.get("updatedDate");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
        assertThat(registerDate).isNotNull();
        assertThat(updatedDate).isNotNull();

        global_id = id;
    }

    public void hitApiDeleteUser() {
        res = deleteUser(setUrl, global_id);
    }
}
