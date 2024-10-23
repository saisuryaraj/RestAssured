package day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*
given() --> to write all the pre -req
when() --> to give the http req get,post,put,delete
then() --> for the validations (sometimes we use and)
*/

public class HTTPrequests {
	
	int id;
	@Test(priority = 1)
	void getUser() {
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	}
	@Test(priority = 2)
	void createUser() {
		HashMap data =new HashMap();//data should be in key and value pair
		data.put("name", "morpheus");
		data.put("job", "leader");
		id=given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
//		.then()
//			.statusCode(201)
//			.body("name", equalTo("morpheus"))
//			.log().all();
	}
	@Test(priority = 3,dependsOnMethods = {"createUser"})
	void updateUser() {
		HashMap data =new HashMap();//data should be in key and value pair
		data.put("name", "raj");
		data.put("job", "leader");
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/2"+id)
			
		.then()
			.statusCode(200)
			.body("name", equalTo("raj"))
			.log().all();
	}
	
	@Test(priority = 4)
	void deleteUser() {
		given()
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204)
		.log().all();
	}
	
}
