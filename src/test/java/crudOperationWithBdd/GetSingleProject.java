package crudOperationWithBdd;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetSingleProject {
	
	@Test
	public void getSingleProject() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		when()
		.get("/projects/TY_PROJ_4678")
		
		.then()
		.statusCode(200)
		.log().all()
		.contentType(ContentType.JSON).time(Matchers.lessThan(2000l), TimeUnit.MILLISECONDS);
		
	}
}
