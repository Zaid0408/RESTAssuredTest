import org.testng.annotations.Test;

import  io.restassured.RestAssured;
import io.restassured.response.Response;

public class SimpleAPITest {
    @Test
    public static void main(String[] args) {
        // Define API Base URL
        String baseUrl = "https://jsonplaceholder.typicode.com";

        // Send a GET request
        Response response = RestAssured
                .given()
                .when()
                .get(baseUrl + "/posts/1");

        // Print the Response Body
        System.out.println("Response Body: " + response.getBody().asString());

        // Print the Status Code
        System.out.println("Status Code: " + response.getStatusCode());

        // Validate Status Code
        if (response.getStatusCode() == 200) {
            System.out.println("Test Passed: Status is 200 OK");
        } else {
            System.out.println("Test Failed: Status is " + response.getStatusCode());
        }
    }
}
