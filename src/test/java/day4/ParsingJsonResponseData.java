package day4;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonResponseData {

	@Test(priority = 1)
	void testJsonResponse() {
		//approach 1
		
//	    given()
//	        .contentType(ContentType.JSON)
//	    .when()
//	        .get("http://localhost:3000/students/")
//	    .then()
//	        .statusCode(200)
//	        .header("Content-Type", "application/json")
//	        .body("[1].name", equalTo("Raj"))  // Make sure the path is correct
//	        .log().all();
		
		
		//approach 2
		Response res=given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/students/");
//		Assert.assertEquals(res.getStatusCode(),200);
//		Assert.assertEquals(res.header("Content-Type"), "application/json");
//		String name=res.jsonPath().get("[1].name").toString();
//		Assert.assertEquals(name,"Raj");
		
		//JSONObject Class
		JSONArray jarray=new JSONArray(res.asString());
		  //System.out.println("the json array is "+jarray);
		  for(int i=0;i<jarray.length();i++)
         {
			  String name=jarray.getJSONObject(i).get("name").toString();
			  System.out.println(i+":" + name); }
		
	}

}
