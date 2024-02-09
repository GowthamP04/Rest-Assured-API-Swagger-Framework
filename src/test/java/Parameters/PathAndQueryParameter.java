package Parameters;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



import org.testng.annotations.Test;

public class PathAndQueryParameter {
	
	//https://reqres.in/api/users?page=2&id=5
	
	@Test
	public void testQueryAndPathParameter(){
	
	given().relaxedHTTPSValidation()
	 	.pathParam("mypath", "users")  //path parameter
	 	.queryParam("page", 2)  //query parameter
	 	.queryParam("id", 5)  //query parameter
	
	 	//path params are used to identify a specific resource
	 	//query params are used to filter and sort data
	 	
	.when()
		.get("https://reqres.in/api/{mypath}")

	.then()
		.statusCode(200)
		.log().all();
	
	}
}  
