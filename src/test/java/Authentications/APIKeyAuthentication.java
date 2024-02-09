package Authentications;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class APIKeyAuthentication {

	//@Test(priority = 1)
	public void testAPIKeyAuthentication()
	{
		//Method1
		given().relaxedHTTPSValidation()
			.queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c") //appid is APIKey
			
		.when()
			.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
			
		.then()
			.statusCode(200)
			.log().all();
		
			}
	
	//Method2
	@Test(priority = 2)
	public void testAPIKeyAuthertication2() {
	
			given().relaxedHTTPSValidation()
				.queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c")
				
				.pathParam("mypath","data/2.5/forecast/daily")
			
				.queryParam("q", "Delhi")
				
				.queryParam("units", "metric")
				
				.queryParam("cnt", "7")
				
				
			.when()
				.get("https://api.openweathermap.org/{mypath}")
			
			.then()
				.statusCode(200)
				.log().all();

		}
		
}
