package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

/*
 * 1.HashMap
 * 2.org.json
 * 3.POJO(plain Old Java Object)
 * 4.external json file
 * */
public class WaysToCreatePostReq {
	// using HashMap
	String id;

	// @Test(priority = 1)
	void TestPostUsingHashMap() {
		HashMap data = new HashMap();
		data.put("name", "kiran");
		data.put("location", "hyderabad");
		data.put("mobile", "7410852012");
		String courseArr[] = { "c", "c++", "java" };
		data.put("courses", courseArr);

		id = given().contentType("application/json").body(data).when().post("http://localhost:3000/students").jsonPath()
				.getString("id");
//	.then()
//		.statusCode(201)
//		.body("name",equalTo("kiran"))
//		.body("", null)
//		.log().all();
	}

	// using org.json
	//String id2;

	//@Test(priority = 1)
	void TestPostUsingOrg() {
		JSONObject data = new JSONObject();
		data.put("name", "kumar");
		data.put("location", "secunderabad");
		data.put("mobile", "8520741054");
		String courseArr[] = { "c", "java" };
		data.put("courses", courseArr);

		id = given().contentType("application/json").body(data.toString()).when().post("http://localhost:3000/students")
				.jsonPath().getString("id");
//		.then()
//			.statusCode(201)
//			.body("name",equalTo("kiran"))
//			.body("", null)
//			.log().all();
	}

	//using POJO
	//@Test(priority = 1)
	void TestPostUsingPOJO() {
		POJO_post data = new POJO_post();
		data.setName("kumar");
		data.setLocation("secunderabad");
		data.setMobile("8520741054");
		String courseArr[] = { "c", "java" };
		data.setCourses(courseArr);

		id = given().contentType("application/json").body(data).when().post("http://localhost:3000/students")
				.jsonPath().getString("id");
//		.then()
//			.statusCode(201)
//			.body("name",equalTo("kiran"))
//			.body("", null)
//			.log().all();
	}
	
	@Test(priority = 1)
	void TestPostUsingExtFile() throws FileNotFoundException {
		File f= new File("D:\\Eclipse\\RestAssured\\Body.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
		
		id = given().contentType("application/json").body(data.toString()).when().post("http://localhost:3000/students")
				.jsonPath().getString("id");
//		.then()
//			.statusCode(201)
//			.body("name",equalTo("kiran"))
//			.body("", null)
//			.log().all();
	}
	
	@Test(priority = 2)
	void deletingStudent() {
		given().when().delete("http://localhost:3000/students/" + id).then().statusCode(200).log().all();
	}

}
