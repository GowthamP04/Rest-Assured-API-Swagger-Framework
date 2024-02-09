package Authentications;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class BearerTokenAuthentication {  // github bearer token

	@Test(priority=1)
		public void testBearerTokenAuthentication()
		{
			String bearerToken="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";
			
			given().relaxedHTTPSValidation()
				.headers("Authorization","Bearer "+bearerToken)
			
			.when()
				.get("https://api.github.com/user/repos")
				
			.then()
				.statusCode(200)
				.log().all();
			
			
		}
}
