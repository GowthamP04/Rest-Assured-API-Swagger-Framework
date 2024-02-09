package SchemaValidations;

import static io.restassured.RestAssured.DEFAULT_BODY_ROOT_PATH;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

public class XMLSchemaValidation {

	
	@Test
	public void testXMLSchemaValidation() {
		
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
			
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("Travelers.xsd"));
			
	}

	
}
