package APIChaining;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {

	@Test
	public void testUpdateUser(ITestContext context) {
		
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "female");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String BearerToken = "e8898306eafbb2ca0258a6ef8a49f036906d6c9ebdb28499ed263918efc4e263";
		
		//this should come from getuser request
		//int id = (Integer) context.getAttribute("user_id");  //this is only available at the test level
		
		int id = (Integer) context.getSuite().getAttribute("user_id");  //this is only available at the suite level
		
		given().relaxedHTTPSValidation()
			.headers("Authorization","Bearer "+BearerToken)
			.contentType("application/json")
			.body(data.toString())
			.pathParam("id", id)
		
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
			
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
