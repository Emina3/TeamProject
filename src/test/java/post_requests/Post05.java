package post_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ResponsePojo;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post05 extends AutomationBaseUrl {

     /*
    Given
         https://automationexercise.com/api/verifyLogin
      And
           password:zenica
      When
         User sends POST request
       Then
         Status code is 200
       And
          Response body should be like {
                                            "responseCode": 400,
                                            "message": "Bad request, email or password parameter is missing in POST request."
                                        }

     */

/// API 8: POST To Verify Login without email parameter
    @Test
    public void post05() {
        //Set the url
        spec.pathParam("first", "verifyLogin");


        Response response = given().spec(spec).urlEncodingEnabled(true).
                 param("password", "zenica").
                header("Accept", ContentType.JSON.getAcceptHeader()).post("/{first}");
        response.jsonPath().prettyPrint();

        //Do Assertion

        ResponsePojo actualData1 = JsonUtils.covertJsonToJavaObject(response.asString(),ResponsePojo.class);
        System.out.println("actualData = " + actualData1);

        assertEquals(200, response.statusCode());
        assertEquals("400", actualData1.getResponseCode().toString());
        assertEquals("Bad request, email or password parameter is missing in POST request.", actualData1.getMessage());

        // ObjectMapper and Pojo

  //       ResponsePojo actualData = new ObjectMapper().readValue(response.asString(),ResponsePojo.class);
//        System.out.println("actualData = " + actualData);
//
//
//        // Do assertion
//        assertEquals(200, response.statusCode());
//        assertEquals("400", actualData.getResponseCode().toString());
//        assertEquals("Bad request, email or password parameter is missing in POST request.", actualData.getMessage());
    }
}