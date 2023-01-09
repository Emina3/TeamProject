package put_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ResponsePojo;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends AutomationBaseUrl {



    /*
      Given
           https://automationexercise.com/api/updateAccount
      When
           User sends :Request Parameters   : name, email, password,
                                             title (for example: Mr, Mrs, Miss), birth_date, birth_month,
                                             birth_year, firstname, lastname, company, address1, address2,
                                             country, zipcode, state, city, mobile_number
      Then
          Status code is 200
     And
        Response Message: User updated!

 */

    //// API 13: PUT METHOD To Update User Account
    @Test
    public void put02() {  // email parameter is missing in PUT request.
        //Set the url
        spec.pathParam("first", "updateAccount");


        Response response = given().spec(spec).urlEncodingEnabled(true).
                param("name", "emmily").
                param("email", "emma234@gmail.com").param("password", "zenica").
                param("title", "Miss").
                param("birth_date", "22").param("birth_month", "09").
                param("birth_year", "2009").param("firstname", "Emiliana").
                param("lastname", "Bayazitli").param("company", "Alsu d.o.o.").
                param("address1", "Stupska 19/9").param("country", "Canada").
                param("zipcode", "71000").param("state", "Travnik").
                param("city", "Torono").param("mobile_number", "+38762123418").


                header("Accept", ContentType.JSON.getAcceptHeader()).put("/{first}");
        response.jsonPath().prettyPrint();


        //Do Assertion


        ResponsePojo actualData1 = JsonUtils.covertJsonToJavaObject(response.asString(), ResponsePojo.class);
        System.out.println("actualData = " + actualData1);

        assertEquals(200, response.statusCode());
        assertEquals("200", actualData1.getResponseCode().toString());
        assertEquals("User updated!", actualData1.getMessage());


    }

}
