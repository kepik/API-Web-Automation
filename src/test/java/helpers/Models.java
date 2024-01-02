package helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helpers.Utility.*;

public class Models {
    private static RequestSpecification request;
    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("app-id","659277e0bf60ad513e95584b");
    }
    public static Response getListUsers(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }
    public static Response postCreateUser(String endpoint) {
        String lastName = "Create User";
        String firstName = "Test";
        String email = generateRandomEmail();

        JSONObject payload = new JSONObject();
        payload.put("lastName", lastName);
        payload.put("firstName", firstName);
        payload.put("email", email);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);

    }
    public static Response putUpdateUser(String endpoint, String user_id) {
        setupHeaders();

        String firstName = "Test";
        String lastName = "Update User";

        JSONObject payload = new JSONObject();
        payload.put("lastName", lastName);
        payload.put("firstName", firstName);

        String finalEndpoint = endpoint +"/"+ user_id;
        return request.body(payload.toString()).when().put(finalEndpoint);
    }
    public static Response deleteUser(String endpoint, String user_id) {
        setupHeaders();
        String finalEndpoint = endpoint +"/"+ user_id;
        return request.when().delete(finalEndpoint);
    }
}
