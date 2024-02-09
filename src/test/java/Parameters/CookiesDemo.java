package Parameters;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {

	//@Test(priority = 1)
	public void testCookies() {
		
		given().relaxedHTTPSValidation()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.cookie("AEC","Ackid1R6jKiGAYlFP5SngkYEKWVZE8mnr6SdPjdwigUmd98ZzJerSi5T1z0")
			.log().all();
	}
	
	@Test(priority = 2)
	public void getCookiesInfo() {
		
		Response res = given().relaxedHTTPSValidation()
		
		.when()
			.get("https://www.google.com/");
		
		//get single cookie info
		//String cookievalue = res.getCookie("AEC");
		//System.out.println("Value of cookie is---->"+cookievalue);
		
		//get all cookies info
		Map<String, String> cookiesvalue = res.getCookies();
		System.out.println(cookiesvalue.keySet());
		
		for (String k : cookiesvalue.keySet()) {
			String cookievalue = res.getCookie(k);
			System.out.println(k+"       "+cookievalue);
			
		}
		
	}
}
