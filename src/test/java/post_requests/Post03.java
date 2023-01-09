package post_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ResponsePojo;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends AutomationBaseUrl {

    // *********
    //API 6: POST To Search Product without search_product parameter

      /*
     Given
          https://automationexercise.com/api/searchProduct
      When
          user sends Post request
      Then
          Status Code is 400
       And
          Response message : Bad request, search_product parameter is missing in POST request.
     */


    @Test
    public void post03() {
        //Set the url
        spec.pathParam("first", "searchProduct");

        //Send the request and get the response
        Response response = given().spec(spec).
                urlEncodingEnabled(true).
                header("Accept", ContentType.JSON.getAcceptHeader()).

                post("/{first}");
        response.jsonPath().prettyPrint();


        //Do Assertion

//         ResponsePojo actualData = new ObjectMapper().readValue(response.asString(),ResponsePojo.class);
//         System.out.println("actualData = " + actualData);

        ResponsePojo actualData = JsonUtils.covertJsonToJavaObject(response.asString(), ResponsePojo.class);
        System.out.println("actualData = " + actualData);

//
        assertEquals(200, response.statusCode());
        assertEquals("400", actualData.getResponseCode().toString());
        assertEquals("Bad request, search_product parameter is missing in POST request.", actualData.getMessage());
    }

}
