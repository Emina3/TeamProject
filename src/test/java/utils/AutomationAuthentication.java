package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AutomationAuthentication {

    public static void main(String[] args) {
        generateToken();
    }

    public static String generateToken(){

        Map<String ,Object> json = new HashMap<>();
        json.put("password","123admin");
        json.put("rememberMe",true);
        json.put("username","Admin");

        Response response = given().contentType(ContentType.JSON).body(json).when().post(" https://automationexercise.com/api/authenticate");
        response.jsonPath().prettyPrint();


        return response.jsonPath().getString("id_token");

    }


}
