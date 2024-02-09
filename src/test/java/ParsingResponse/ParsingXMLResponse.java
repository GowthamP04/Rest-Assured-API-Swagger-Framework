package ParsingResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLResponse {

	//@Test(priority = 1)
	public void testXMLResponse() {
		//Approach 1
		/*given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then()
			.statusCode(200)
			.header("Content-Type", "application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page", equalTo("1"))
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));
	}
	*/
	
	//Approach 2
	
		Response res = given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
			
			Assert.assertEquals(res.getStatusCode(), 200);
			Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
			
			String pageno = res.xmlPath().get("TravelerinformationResponse.page").toString();
			Assert.assertEquals(pageno, "1");
			
			String field = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
			Assert.assertEquals(field, "Developer");
	}
	
	@Test(priority = 2)
	public void testXMLResponseBody() {
		
		Response res = given()
				
				.when()
				.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xmlobj = new XmlPath(res.asString());
		
		//verify the total numer of travellers
		
		List<String> travellers = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		
		//for (String traveler : travellers) {
			
		//	System.out.println(traveler);
		//}
		
		Assert.assertEquals(travellers.size(), 10);
		
		//verify traveller name is present in response
		
		List<String> travellernames = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		Boolean status = false;
		for (String travelername : travellernames) {
			
			//System.out.println(travelername);
			if(travelername.equals("Developer")) {
				
				status = true;
				break;
			}
		}
		Assert.assertEquals(status, true);
	}
}
