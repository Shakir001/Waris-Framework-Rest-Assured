package differentWayToPostARequest;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ThroughHashmapPostARequest {
	
	
	@Test
	public void postRequest() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		HashMap  map = new HashMap();
		map.put("createdBy", "raina");
		map.put("projectName", "ICC");
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
		
		
	}

}
