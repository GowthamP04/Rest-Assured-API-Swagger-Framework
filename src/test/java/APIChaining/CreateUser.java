package APIChaining;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {
	
	@Test
	public void testCreateUser(ITestContext context) {
		
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String BearerToken = "e8898306eafbb2ca0258a6ef8a49f036906d6c9ebdb28499ed263918efc4e263";
		
		int id = given().relaxedHTTPSValidation()
			.headers("Authorization","Bearer "+BearerToken)
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
		
		System.out.println("Generated id is :"+id);
		
		//context.setAttribute("user_id", id);  //this is only available at the test level
		
		context.getSuite().setAttribute("user_id", id);  //this is only available at the suite level
		
	}

}
