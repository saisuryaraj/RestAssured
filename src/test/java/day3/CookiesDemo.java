package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import java.util.Map;

public class CookiesDemo {
	//@Test(priority = 1)
	void testCookies() {
		given()
			
		.when()
			.get("https://www.google.com/")
		.then()
			.cookie("AEC","AVYB7covb91hvXqRkhZcLUjPmOuj7rHW83lVgr3qFgV0DzgluGC_GL3f7w")
			//.cookie("518=jQLErSfNh1rgRqmx6cYhy1a_ST1LevE2sM4x-rV6-ngnTv8BvHAeShbxOIwJp3YITUHo6Pxs3LPTHrIbGIB0hm2FM5o6pdzbjKFXYJ0xG1JlkjNcWhqVMY2WBSnZVoOd2sbLmOvGy6Cd4Wcphl4mctXuhgJ4woCb5dH5-obMAN8QvQGwMoonWP4jA0hw3NjcD3VS")
			.log().all();
	}
	
	@Test(priority = 2)
	void getCookiesInfo() {
		Response res =given()
			
		.when()
			.get("https://www.google.com/");
		
//		//get single cookie info
//		String cookie_value=res.getCookie("AEC");
//		System.out.println(cookie_value);
		
		//get all cookies info
		Map<String,String>Cookies_values=res.getCookies();
		//System.out.println(Cookies_values.keySet());
		
		for(String k:Cookies_values.keySet()) {
			String cookie_value=res.getCookie(k);
			System.out.println(k+" "+cookie_value);
		}
	}
}


















