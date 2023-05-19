package crudOperationWithBdd;

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
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "M S DHONI");
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		
		.when()
		.put("/projects/TY_PROJ_4678")
		
		.then()
		.contentType(ContentType.JSON)
		.log().all()
		.statusCode(200).time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
	}

}
