package Parameters;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Headers {

	  // @Test(priority = 1)
		public void testHeaders() {
			
			given().relaxedHTTPSValidation()
			
			.when()
				.get("https://www.google.com/")
			
			.then()
				.header("Content-Type", "text/html; charset=ISO-8859-1")
				.header("Content-Encoding", "gzip")
				.header("Server", "gws");
				
		}
	   
	   @Test(priority = 2)
		public void getHeaders() {
			
		   Response res = given().relaxedHTTPSValidation()
			
			.when()
				.get("https://www.google.com/");
			
			//get single header info
		   //String headervalue = res.getHeader("Content-Type");
		   //System.out.println("The value of content-type header is :"+headervalue);
				
			//get all headers info
		   io.restassured.http.Headers allheaders = res.getHeaders();
		   
		   for (Header hd : allheaders) {
			   System.out.println(hd.getName()+"        "+hd.getValue());
			
		}
		}
}
