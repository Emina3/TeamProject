package post_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ResponsePojo;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;


public class Post04 extends AutomationBaseUrl{

    /*
    Given
         https://automationexercise.com/api/verifyLogin
      And
          email: amina.pez+1@gmail.com  and password:zenica
      When
         User sends Post request
       Then
         Status code is 200
       And
          Response body should be like {
                                        "responseCode": 200,
                                        "message": "User exists!"
                                         }

     */

    //// API 7: POST To Verify Login with valid details
    @Test
    public void post04(){
        //Set the url
        spec.pathParam("first","verifyLogin");


        Response response = given().spec(spec).urlEncodingEnabled(true).
                param("email","amina.pez+1@gmail.com").param("password","zenica").
                header("Accept",ContentType.JSON.getAcceptHeader()).post("/{first}");
        response.jsonPath().prettyPrint();



        //Do Assertion

        ResponsePojo actualData1 = JsonUtils.covertJsonToJavaObject(response.asString(),ResponsePojo.class);
        System.out.println("actualData = " + actualData1);

        assertEquals(200, response.statusCode());
        assertEquals("200", actualData1.getResponseCode().toString());
        assertEquals("User exists!", actualData1.getMessage());


        // ObjectMapper and Pojo

//        ResponsePojo actualData = new ObjectMapper().readValue(response.asString(),ResponsePojo.class);
//        System.out.println("actualData = " + actualData);
////
////
//        // Do assertion
//        assertEquals(200, response.statusCode());
//        assertEquals("200", actualData.getResponseCode().toString());
//        assertEquals("User exists!", actualData.getMessage());



    }
}
