package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class ApiStepDefinition {
    Response response;
    @Given("user goes to api end point {string}")
    public void userGoesToApiEndPoint(String api_end_point) {
         response=given().
                header("Authorization","Bearer"+ ConfigReader.getProperty("api_bearer_token"),"Content-Type", ContentType.JSON).
                when().get(api_end_point).
                then().contentType(ContentType.JSON).
                extract().
                response();

    }

    @And("read all customers and set response")
    public void readAllCustomersAndSetResponse() {
        response.prettyPrint();
    }
}
