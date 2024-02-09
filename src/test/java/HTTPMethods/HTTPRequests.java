package HTTPMethods;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;


public class HTTPRequests {
	
	int id;

	@Test(priority = 1)
	public void getUsers() {  //get user
		
		given().relaxedHTTPSValidation()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
	}
	
	@Test(priority = 2)
	public void createUser() {  //post user
		
		HashMap data = new HashMap();
		data.put("name", "gowtham");
		data.put("job", "testing");
		
		id = given().relaxedHTTPSValidation()
			.contentType("application/json") //json format
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
			
		//.then()
		//  .statusCode(201)
		//	.log().all();
	}
	
	@Test(priority = 3, dependsOnMethods = {"createUser"})
	public void updateUser() {  //put user
		
		HashMap data = new HashMap();
		data.put("name", "john");
		data.put("job", "developer");
		
		 given().relaxedHTTPSValidation()
			.contentType("application/json") //json format
			.body(data)
			
		.when()
			.put("https://reqres.in/api/users/"+id)
			
		.then()
		  .statusCode(200)
		  .log().all();
	}
	
	@Test(priority = 4)
	public void deleteUser() {  //delete user
		
		given().relaxedHTTPSValidation()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
			
		.then()
			.statusCode(204)
			.log().all();
	}
}
