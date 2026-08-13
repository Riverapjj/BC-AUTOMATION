package com.cuscatlan.automation.domains.reqres.api.tests;

import com.cuscatlan.automation.core.base.BaseAPITest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersApiTest extends BaseAPITest {

    @Test(testName = "Get existing user")
    @Description("Validating if existing user is been returned")
    private void getUser () {
        given()
                .header("x-api-key", apiKey)
                .when()
                .get(baseUrl + "/api/users/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", containsString("@reqres.in"))
                .body("data.first_name", notNullValue())
                .body("data.last_name", not(isEmptyOrNullString()));

    }

    @Test(testName = "Get non-existing user")
    @Description("Validate that requesting a non-existing user returns HTTP 404 with an empty JSON response")
    private void negativeScenario () {

        given()
                .header("x-api-key", apiKey)
                .when()
                .get(baseUrl + "/api/users/999")
                .then()
                .statusCode(404)
                .body("size()", equalTo(0));

        /*
        Response response = given()
                .header("x-api-key", apiKey)
                .when()
                .get(baseUrl + "/api/users/999");

        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());

        response.then()
                .statusCode(404);
        */
    }
}
