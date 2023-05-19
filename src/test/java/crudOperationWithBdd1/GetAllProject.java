package crudOperationWithBdd1;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetAllProject {
	
	@Test
	public void getAllProject() {
		
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		when()
		.get("/projects")
	 
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
		
	}
}
