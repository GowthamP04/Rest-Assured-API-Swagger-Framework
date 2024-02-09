package SchemaValidations;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

public class JSONSchemaValidation {
	
	@Test
	public void testJSONSchemaValidation() {
		
		given()
		
		.when()
			.get("http://localhost:3000/store")
			
		.then();
		//.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));
			//.assertThat().body("storeJsonSchema.json", null);
	}

	

	

}
