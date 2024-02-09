package APIChaining;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {

	@Test
	public void testGetUser(ITestContext context) {
		
		//this should come from createuser request
		//int id = (Integer) context.getAttribute("user_id");  //this is only available at the test level
		
		int id = (Integer) context.getSuite().getAttribute("user_id");  //this is only available at the suite level
		
		String BearerToken = "e8898306eafbb2ca0258a6ef8a49f036906d6c9ebdb28499ed263918efc4e263";
		
		given().relaxedHTTPSValidation()
			.headers("Authorization","Bearer "+BearerToken)
			.pathParam("id", id)
		
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
			.statusCode(200)
			.log().all();
	}
}
