package tests;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojo.Zeel;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PatchWithPojo {


    @Test
    public void deserializeThis() throws FileNotFoundException {
        // Rest assured uses gson to do deserialization
        // Gson converts the input to java object,  objects to output
        Gson gson = new Gson();

        // file that want to read
        FileReader reader = new FileReader("src/test/resources/zeel.json");

        // fromJson  -> takes json input source and converts to object
        Zeel job = gson.fromJson( reader, Zeel.class);
        System.out.println(job);

    }



    @Test
    public void test() {
        Zeel z = new Zeel("SR19760827202206208364", "Tester", "something");

        System.out.println( z );
        System.out.println( z.getId() );
        System.out.println( z.getName() );
        System.out.println( z.getAddress() );
    }




}
