package post_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.CategoryPojo;
import pojos.ProductListPojo;
import pojos.UsertypePojo;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post01 extends AutomationBaseUrl {

    /*
     Given
         https://automationexercise.com/api/productsList
     When
         User sends POST request
      And
         The body should be like
                                    {“id”: 44,
                                    “name”: “Red Top”,
                                    “price”: “Rs. 600”,
                                    “brand”: “Polo”,
                                    “category”: {
                                        “usertype”: {
                                            “usertype”: “Women”
                                        },
                                        “category”: “Tops”
                                    }
                                }
     Then
         Response code is 405
      And
        Response Message should be "This request method is not supported"

     */

    @Test
    public void post01() throws IOException {
        // Set the URL
        spec.pathParam("first", "productsList");

        // Set the expected data
        UsertypePojo usertype = new UsertypePojo("Women");
        CategoryPojo category = new CategoryPojo(usertype, "Tops");

        ProductListPojo expectedData = new ProductListPojo(44, "Red Top", "Rs. 600", "Polo", category );
        System.out.println("expectedData = " + expectedData);

        // Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.jsonPath().prettyPrint();

        // Do assertion
        // De-serialisation
        // We need to create pojo class for response body

       // ResponsePojo actualData = new ObjectMapper().readValue(response.asString(),ResponsePojo.class);
       // System.out.println("actualData = " + actualData);

//        // Do assertion
//        assertEquals(200, response.statusCode());
//        assertEquals("405", actualData.getResponseCode().toString());
//        assertEquals("This request method is not supported.", actualData.getMessage());

    }
}