package crudOperationWithBdd;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;


public class CreateProject {
	
	@Test
	public void createProject() {
		
		
		baseURI="http://rmgtestingserver";
		port = 8084;
		
		JavaLibrary ran = new JavaLibrary();
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "sunil");
		jobj.put("projectName", "tiger"+ran.getRandom());
		jobj.put("status", "done");
		jobj.put("teamSize", 10);
		
		
		
		given().body(jobj).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS);
	}
}
