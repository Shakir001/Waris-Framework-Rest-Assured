package crudOperationWithBdd1;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class UpdateProject {
	
	@Test
	public void updateProject() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		JSONObject j = new JSONObject();
		j.put("projectName", "Lion");
		j.put("teamSize", 10);
		
		given()
		.body(j)
		.contentType(ContentType.JSON)
		
		.when()
		.put("/projects/TY_PROJ_5272")
		
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
		
	}

}
