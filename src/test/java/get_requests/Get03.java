package get_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get03 extends AutomationBaseUrl {


    /*
     Given
          https://automationexercise.com/api/getUserDetailByEmail
       And
            Request Parameters: email : embayazitli007@gmail.com
      When
          User sends GET request
      Then
          Status Code is 200
       And
          Response message : User  Detail
     */

    /// API 14: GET user account detail by email

    @Test
    public void get03() {
        //Set the url
        spec.pathParam("first", "getUserDetailByEmail");

        // Send the request and get the response
        Response response = given().spec(spec).urlEncodingEnabled(true).
                param("email", "embayazitli007@gmail.com").
                header("Accept", ContentType.JSON.getAcceptHeader()).get("/{first}");
        response.jsonPath().prettyPrint();

        // Do Assertion

        assertEquals(200, response.statusCode());


    }
}
