package PostRequestPayloads;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.internal.support.FileReader;

public class PostRequestPayloadsMultipleWays {
	
	// 1)post request body using hashmap
	
	//@Test(priority = 1)
	public void testPostUsingHashMap() {
		
		HashMap data = new HashMap();
		
		data.put("name", "John");
		data.put("location", "india");
		data.put("phone", "1234567890");
		
		String courseArr[] = {"Java","Selenium"};
		data.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name", equalTo("John"))
			.body("location", equalTo("india"))
			.body("phone", equalTo("1234567890"))
			.body("courses[0]",equalTo("Java"))
			.body("courses[1]",equalTo("Selenium"))
			.log().all();
	}
	
	//2)post request body using org.json library
	
		//@Test(priority = 1)
		public void testPostUsingJsonLibrary() {
			
			JSONObject data = new JSONObject();
			
			data.put("name", "John");
			data.put("location", "india");
			data.put("phone", "1234567890");
			
			String courseArr[] = {"Java","Selenium"};
			data.put("courses", courseArr);
			
			given()
				.contentType("application/json")
				.body(data.toString())
			
			.when()
				.post("http://localhost:3000/students")
			
			.then()
				.statusCode(201)
				.body("name", equalTo("John"))
				.body("location", equalTo("india"))
				.body("phone", equalTo("1234567890"))
				.body("courses[0]",equalTo("Java"))
				.body("courses[1]",equalTo("Selenium"))
				.log().all();
		}
		
		//3)post request body using POJO class
		
			//@Test(priority = 1)
			public void testPostUsingPOJO() {
				
				POJO_PostRequest data = new POJO_PostRequest();
				
				data.setName("John");
				data.setLocation("india");
				data.setPhone("1234567890");
				
				String courseArr[] = {"Java","Selenium"};
				data.setCourses(courseArr);
				
				given()
					.contentType("application/json")
					.body(data)
				
				.when()
					.post("http://localhost:3000/students")
				
				.then()
					.statusCode(201)
					.body("name", equalTo("John"))
					.body("location", equalTo("india"))
					.body("phone", equalTo("1234567890"))
					.body("courses[0]",equalTo("Java"))
					.body("courses[1]",equalTo("Selenium"))
					.log().all();
			}
			
			//4)post request body using External JSON file
			
			@Test(priority = 1)
			public void testPostUsingExternalJsonFile() throws FileNotFoundException {
				
				File file = new File("C:\\Users\\GO20382992\\eclipse-workspace\\RestAssuredAPI\\src\\test\\java\\PostRequestPayloads\\body.json");
				
				java.io.FileReader fr = new java.io.FileReader(file);
				
				JSONTokener jt = new JSONTokener(fr);
				
				JSONObject data = new JSONObject(jt);
				
				
				given()
					.contentType("application/json")
					.body(data.toString())
				
				.when()
					.post("http://localhost:3000/students")
				
				.then()
					.statusCode(201)
					.body("name", equalTo("John"))
					.body("location", equalTo("india"))
					.body("phone", equalTo("1234567890"))
					.body("courses[0]",equalTo("Java"))
					.body("courses[1]",equalTo("Selenium"))
					.log().all();
			}
	
	//deleting students record
	//@Test(priority = 2)
	public void testDelete() {
		
		given()
		
		.when()
			.delete("http://localhost:3000/students/f962")
		
		.then()
			.statusCode(200);
	}

}
