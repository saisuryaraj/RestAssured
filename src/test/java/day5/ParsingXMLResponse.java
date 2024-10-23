package day5;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingXMLResponse {
	
	//@Test(priority = 1)
	void testXmlResponse() {//approach 1
		
		given()
		.when()
			.get("https://fakerestapi.azurewebsites.net/api/v1/Books")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8; v=1.0")
			.body("[0].title", equalTo("Book 1"))
			.log().all();
		
		//approach2
		
	}
	//@Test
	void testXmlresponse2() {
		Response res=given()
				.when()
					.get("https://fakerestapi.azurewebsites.net/api/v1/Books");
				Assert.assertEquals(res.getStatusCode(), 200);
				Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8; v=1.0");
//				String id=res.xmlPath().get("[0].title").toString();
//				System.out.println(id);
	}
	
	
	@Test
	void testXmlresponse3() {
		Response res=given()
				.when()
					.get("https://fakerestapi.azurewebsites.net/api/v1/Books");
				
	}
}
