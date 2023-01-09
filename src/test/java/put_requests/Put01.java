package put_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Put_Pojo;
import pojos.ResponsePojo;
import utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utils.AutomationAuthentication.generateToken;

public class Put01 extends AutomationBaseUrl {

    /*
          Given
                https://automationexercise.com/api/brandsList
           And
              {
                "id": 29,
                "brand": "Bellissima"
                }
          When
              user sends Put Request
          Then
              HTTP Status Code is 200
           And
              Response Code is 405
            And
               Response Message is :" This request method is not supported."

     */

    @Test
    public void put01(){
        //Set the Url
        spec.pathParam("first","brandsList");

        //Set the expected data
        Put_Pojo expectedData = new Put_Pojo(29,"Bellissima");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response  //header("Authorization","Bearer "+generateToken())
       Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{first}");
       response.jsonPath().prettyPrint();

       //Do Assertion
       //De-Serialization

        ResponsePojo actualData1 = JsonUtils.covertJsonToJavaObject(response.asString(),ResponsePojo.class);
        System.out.println("actualData = " + actualData1);

        assertEquals(200, response.statusCode());
        assertEquals("405", actualData1.getResponseCode().toString());
        assertEquals("This request method is not supported.", actualData1.getMessage());



//       ResponsePojo actualData = new ObjectMapper().readValue(response.asString(),ResponsePojo.class);
//        System.out.println("actualData = " + actualData);
//
//
//        // Do assertion
//        assertEquals(200, response.statusCode());
//        assertEquals("405", actualData.getResponseCode().toString());
//        assertEquals("This request method is not supported.", actualData.getMessage());

    }
}


