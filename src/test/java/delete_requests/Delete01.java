package delete_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ResponsePojo;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete01 extends AutomationBaseUrl {


    // API 9: DELETE To Verify Login

      /*
     Given
          https://automationexercise.com/api/verifyLogin
      When
          User sends Delete request
      Then
          Status Code is 405
       And
          Response message : This request method is not supported.
     */

    @Test
    public void delete01() {
        //Set the url
        spec.pathParam("first", "verifyLogin");

        //Send the request and get the response
        Response response = given().spec(spec).
                urlEncodingEnabled(true).
                header("Accept", ContentType.JSON.getAcceptHeader()).
                delete("/{first}");
        response.jsonPath().prettyPrint();


        //Do Assertion


//         ResponsePojo actualData = new ObjectMapper().readValue(response.asString(),ResponsePojo.class);
//         System.out.println("actualData = " + actualData);

        ResponsePojo actualData = JsonUtils.covertJsonToJavaObject(response.asString(), ResponsePojo.class);
        System.out.println("actualData = " + actualData);

//
        assertEquals(200, response.statusCode());
        assertEquals("405", actualData.getResponseCode().toString());
        assertEquals("This request method is not supported.", actualData.getMessage());

    }

}
