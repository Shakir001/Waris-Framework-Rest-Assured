package crudOperationWithBdd1;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateProject {
	
	@Test
	public void createProject() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		JSONObject j = new JSONObject();
		j.put("createdBy", "rohan");
		j.put("projectName", "Discover");
		
		given()
		.body(j)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
		
	}
}
