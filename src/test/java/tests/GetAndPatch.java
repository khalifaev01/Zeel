package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetKey {


    @Test
    public void GetKeyVerified() {
        Response response = when().get("https://hs4hqu0udj.execute-api.us-east-1.amazonaws.com/test/getkey");
        response.prettyPeek()
        .then().statusCode(200);
        assertTrue(response.asString().contains("940893157622"));
    }

 // 5 + 6
    @Test
    public void PatientTest() {
        Response response = given().queryParam("id","SR19760827202206208364").
                when().get("https://hs4hqu0udj.execute-api.us-east-1.amazonaws.com/test/patient");


        response.then().statusCode(200);

        String responseStr = response.asString();

        String str = "2022-06";
        int x = 0;

        for ( int i = 0; i < responseStr.length()-str.length(); i++ ) {
           String partStr = responseStr.substring( i,  i + str.length());
            if( partStr.equals(str)){
                x++;

            }
        }
        if ( x > 1 ){
            System.out.println("The number of patients in the month of june is " + x );
        }

        assertTrue( responseStr.contains(str) );
        response.prettyPrint();
    }



    @Test
    public void PatchTest() {

        Map<String, Object> obj = new HashMap<>();
        obj.put("id" , "SR19760827202206208364");


        Response response = given().
                queryParam("api_key", "940893157622").
                and().
                body(obj).
                when().
                patch("https://hs4hqu0udj.execute-api.us-east-1.amazonaws.com/test/update");

        System.out.println( response.statusCode()  );

        String responseStr = response.asString();
        assertTrue(responseStr.contains("2022-06") && responseStr.contains("NY"));
        assertFalse(responseStr.contains("NJ"));

        response.prettyPrint();
    }



    @Test
    public void PostTest() {

        Map<String, String> obj = new HashMap<>();
        obj.put("firstName", "Najmuddin" );
        obj.put("lastName", "Khalifaev");
        obj.put("url", "https://github.com/khalifaevnajmmuddin1/Zeel.git");

        Response response = given().
                queryParam("api_key", "940893157622").
                and().
                body(obj).
                post("https://hs4hqu0udj.execute-api.us-east-1.amazonaws.com/test/submit");

         response.statusCode();
         response.prettyPrint();
    }










}
