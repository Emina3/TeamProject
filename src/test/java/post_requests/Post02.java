package post_requests;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ResponsePojo;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post02 extends AutomationBaseUrl {

    /*
     Given
          https://automationexercise.com/api/searchProduct?search_product=tshirt
        And
            Request Parameter: search_product
      When
          User sends Post request
      Then
          Status Code is 200
       And
          Print on the console  searched products list
     */

    ///API 5: POST To Search Product
    @Test
    public void post02() {
        //Set the url
        spec.pathParam("first", "searchProduct").queryParam("search_product", "jeans");

        //Send the request and get the response
        Response response = given().spec(spec).
                urlEncodingEnabled(true).
                header("Accept", ContentType.JSON.getAcceptHeader()).
                param("search_product", "jeans").
                post("/{first}");
        response.jsonPath().prettyPrint();


        //Do Assertion

        assertEquals(200, response.statusCode());
    }

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

    // API 9: DELETE To Verify Login

      /*
     Given
          https://automationexercise.com/api/verifyLogin
      When
          user sends Delete request
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

    //API 10: POST To Verify Login with invalid details

        /*
     Given
          https://automationexercise.com/api/verifyLogin
      When
          user sends Post request
      Then
          Status Code is 404
       And
          Response message : User not found!
     */

    @Test
    public void post06() {
        //Set the url
        spec.pathParam("first", "verifyLogin");

        Response response = given().spec(spec).urlEncodingEnabled(true).
                param("email", "na.pez+1@gmail").param("password", "zen").
                header("Accept", ContentType.JSON.getAcceptHeader()).post("/{first}");
        response.jsonPath().prettyPrint();


        //Do Assertion

//         ResponsePojo actualData = new ObjectMapper().readValue(response.asString(),ResponsePojo.class);
//         System.out.println("actualData = " + actualData);

        ResponsePojo actualData = JsonUtils.covertJsonToJavaObject(response.asString(), ResponsePojo.class);
        System.out.println("actualData = " + actualData);

//
        assertEquals(200, response.statusCode());
        assertEquals("404", actualData.getResponseCode().toString());
        assertEquals("User not found!", actualData.getMessage());
    }

    // ********

    // API 11: POST To Create/Register User Account

    /*
 Given
      https://automationexercise.com/api/createAccount
   When
      user sends email:amina.pez+1@gmail.com  and password:zenica
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
                param("email", "mbayazitli@gmail.com").param("password", "zenica").
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

    // API 12: DELETE METHOD To Delete User Account

      /*
     Given
          https://automationexercise.com/api/deleteAccount
      When
          user sends Delete request
      Then
          Status Code is 200
       And
          Response message : Account deleted!
     */

    @Test
    public void delete02() { // email parameter is missing in DELETE request.
        //Set the url
        spec.pathParam("first", "deleteAccount");

        //Send the request and get the response
        Response response = given().spec(spec).
                urlEncodingEnabled(true).
                param("email", "emma234@gmail.com").param("password", "zenica").
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
        assertEquals("200", actualData.getResponseCode().toString());
        assertEquals("Account deleted!", actualData.getMessage());

    }


    //API 13: PUT METHOD To Update User Account

    /*
Given
     https://automationexercise.com/api/updateAccount
  When
     User sends :Request Parameters: name, email, password,
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
                param("name", "emma").
                param("email", "amina.pez+1@gmail.com").param("password", "zenica").
                param("title", "Miss").
                param("birth_date", "22").param("birth_month", "09").
                param("birth_year", "2009").param("firstname", "Emiliana").
                param("lastname", "Bayazitli").param("company", "Alsu d.o.o.").
                param("address1", "Stupska 19/9").param("country", "Canada").
                param("zipcode", "71200").param("state", "Travnik novi").
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

    //API 14: GET user account detail by email


    /*
     Given
          https://automationexercise.com/api/getUserDetailByEmail
       And
            Request Parameters: email : embayazitli007@gmail.com
      When
          User sends GET request
      Then
          Status Code is 200
       And
          Response message : User  Detail
     */

    /// API 14: GET user account detail by email

    @Test
    public void get03() {
        //Set the url
        spec.pathParam("first", "getUserDetailByEmail");

        // Send the request and get the response
        Response response = given().spec(spec).urlEncodingEnabled(true).
                param("email", "embayazitli007@gmail.com").
                header("Accept", ContentType.JSON.getAcceptHeader()).get("/{first}");
        response.jsonPath().prettyPrint();

        // Do Assertion

        assertEquals(200, response.statusCode());




    }
}
