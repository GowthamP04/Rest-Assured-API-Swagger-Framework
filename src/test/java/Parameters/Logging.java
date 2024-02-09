package Parameters;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Logging {

	@Test(priority = 1)
	public void Logs() {  //get user
		
		given().relaxedHTTPSValidation()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.log().body(); //it will print only body from the response
			//.log().cookies()
			//.log().headers()
	}
	
	
}
