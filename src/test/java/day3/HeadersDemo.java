package day3;

import org.codehaus.groovy.runtime.metaclass.MetaMethodIndex.Header;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class HeadersDemo {

	//@Test
	void testHeader() {
		given()
			
		.when()
			.get("https://www.google.com/")
		.then()
			.header("Expires", "-1")
			.log().all();
	}
	
	@Test
	 void getHeaders() {
        // Sending a GET request to Google's homepage
        Response res = given()
                .when()
                .get("https://www.google.com/");

        // Getting a single header (Content-Type)
        String headerValue = res.getHeader("Content-Type");
        System.out.println("Content-Type: " + headerValue);

        // Getting all headers
        Headers myHeaders = res.getHeaders();
        for (io.restassured.http.Header hd : myHeaders) {
            System.out.println(hd.getName() + ": " + hd.getValue());
        }
    }
}





















