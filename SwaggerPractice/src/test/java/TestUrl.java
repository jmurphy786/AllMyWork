import static io.restassured.RestAssured.given;

import org.junit.Test;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class TestUrl {
	
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	private String theURL = "http://localhost:8090/example/v1/hotels?page=0&size=100";
	
	@Test
	public void CheckThatGetWorks()
	{
		  given()
			.contentType(ContentType.JSON)
			.when()
			.get(theURL)
			.then()
			.statusCode(200);
		
	}

	
	@Test
	public void CheckThatPostWorks()
	{
		JSONObject obj = new JSONObject();
	
		request = given();
		
		request.header("Content-Type", "application/json");
			
		obj.put("name", "Big Bedsxxx");
		obj.put("description", "very basic, small rooms but clean");
		obj.put("city", "Armagh");
		obj.put("rating", 4);
		
		request.body(obj.toString());
		response = request.post("http://localhost:8090/example/v1/hotels");
		
		System.out.println("Get Status Code for posting is: " + response.getStatusCode());
		
	}
	
	@Test
	public void CheckThatDeleteWorks() {
		Response response = given()
				  				.contentType(ContentType.JSON)
				  				.delete("http://localhost:8090/example/v1/hotels/11");
		System.out.println("Delete Status Code is: " + response.statusCode());

	}

	@Test
	public void getObjectByID() {
		
		request = given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:8090/example/v1/hotels");
		
		
        JSONObject obj = new JSONObject(response.body().asString());
        JSONArray results = obj.getJSONArray("content");
   
        
		for (Object o : results)
		{
			JSONObject lol = (JSONObject) o;
			int integer = (Integer) lol.get("id");
			
			if(integer == 7) {
				
				String jsonString = lol.toString();
				System.out.println(jsonString);
			}

		}
	}
	
	@Test
	public void getObjectByHotel() {
		
		request = given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:8090/example/v1/hotels");
		
		
        JSONObject obj = new JSONObject(response.body().asString());
        JSONArray results = obj.getJSONArray("content");
   
        
		for (Object o : results)
		{
			JSONObject lol = (JSONObject) o;
			String hotelName = lol.getString("name");
			
			if(hotelName.equals("Big Bedsxxx")) {
				
				String jsonString = lol.toString();
				System.out.println(jsonString);
			}

		}
	}
}
