package differentWayToPostARequest;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ThroughJsonFilePostARequest {
	
	
	@Test
	public void jsonFile() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		File f = new File("./Emp.json");
		
		given()
		.body(f)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
		
	}
}
