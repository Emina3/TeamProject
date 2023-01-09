package get_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Get01 extends AutomationBaseUrl {

    /*
     Given the URL
            https://automationexercise.com/api/productsList
      When
          User sends HTTP Get request
      Then
         HTTP Status Code is 200
      And
        Content Type is JSON
     And
        response body should be like all products list

     */

    @Test

    public void get01(){

        //Set the url
        spec.pathParam("first","productsList");

        //Set the expected data

        //Send the request and get the response
       Response response= given().spec(spec).when().get("{first}");
       response.jsonPath().prettyPrint();

      response.then().statusCode(200).contentType(ContentType.HTML);


       //Do Assertion
      JsonPath jsonPath= response.jsonPath();

        List<Object> list = response.jsonPath().getList("products.id");
        System.out.println("list = " + list);

        System.out.println("list.size() = " + list.size());

        //Do Assertion

        assertEquals(200,response.statusCode());
        assertEquals("text/html; charset=utf-8",response.contentType());

        assertEquals(34,list.size());


    }
}
