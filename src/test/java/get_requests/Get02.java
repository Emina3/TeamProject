package get_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get02 extends AutomationBaseUrl {

      /*
     Given the URL
            https://automationexercise.com/api/productsList
      When
          User sends HTTP Get request
      Then
         HTTP Status Code is 200
      And
         Response body is all brands list
       */



 @Test
 public void get02() {


     //Set the url
     spec.pathParam("first", "productsList");


     //Set the expected data
     List<String> expectedData = Arrays.asList("Polo", "H&M", "Madame", "Madame", "Mast & Harbour", "H&M", "Madame", "Polo", "Babyhug", "Babyhug", "Allen Solly Junior",
                                               "Kookie Kids", "Babyhug", "Babyhug", "Kookie Kids", "Allen Solly Junior",
                                               "Kookie Kids", "Biba", "Biba", "Biba", "Allen Solly Junior", "H&M", "Polo", "Polo",
                                               "H&M", "Polo", "H&M", "Polo", "Madame", "Biba", "Biba", "Madame",
                                                "Mast & Harbour", "Mast & Harbour");
     System.out.println("expectedData = " + expectedData);


     //Send the request and get the response
     Response response = given().spec(spec).when().get("/{first}");
     response.jsonPath().prettyPrint();

     //Do assertion
     //1)Status code is 200

     Assert.assertEquals(200,response.statusCode());

     //2)  Response body is all brands list
     List<String> brandsActualData = response.jsonPath().getList("products.brand");
     assertEquals(expectedData,brandsActualData);
 }
}

