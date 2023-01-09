package post_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ResponsePojo;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post07 extends AutomationBaseUrl {

    // API 11: POST To Create/Register User Account

    /*
 Given
      https://automationexercise.com/api/createAccount
   When
      User sends email:amina.pez+1@gmail.com  and password:zenica
    Then
      Status code is 201
    And
       Response Message: User created!

  */
    @Test
    public void post07() {
        //Set the url
        spec.pathParam("first", "createAccount");


        Response response = given().spec(spec).urlEncodingEnabled(true).
                param("email", "emili123@gmail.com").param("password", "zenica").
                param("name", "emina").param("title", "Mrs").
                param("birth_date", "20").param("birth_month", "08").
                param("birth_year", "1982").param("firstname", "Emina").
                param("lastname", "Bayazitli").param("company", "Alsu").
                param("address1", "Stupska 19/1").param("country", "Bosnia").
                param("zipcode", "71000").param("state", "Kanton").
                param("city", "Sarajevo").param("mobile_number", "+38762123416").
                header("Accept", ContentType.JSON.getAcceptHeader()).post("/{first}");
        response.jsonPath().prettyPrint();


        //Do Assertion


        ResponsePojo actualData1 = JsonUtils.covertJsonToJavaObject(response.asString(), ResponsePojo.class);
        System.out.println("actualData = " + actualData1);

        assertEquals(200, response.statusCode());
        assertEquals("201", actualData1.getResponseCode().toString());
        assertEquals("User created!", actualData1.getMessage());


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
