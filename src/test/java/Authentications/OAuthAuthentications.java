package Authentications;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class OAuthAuthentications {

	//@Test(priority = 1)
		void testOAuth1Authentication()
		{
			given()
				.auth().oauth("consumerKey","consumerSecrat","accessToken","tokenSecrate") // this is for OAuth1.0 authentication
			.when()
				.get("url")
			.then()
				.statusCode(200)
				.log().all();
			
		}
		
		@Test(priority = 2)
		void testOAuth2Authentication()
		{
			given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
		}
}
