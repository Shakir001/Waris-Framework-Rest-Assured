package crudOperationWithBdd1;

import org.hamcrest.Matchers;
import org.testng.Assert;
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
		.get("/projects/TY_PROJ_5272")
		
		.then()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
		
		
	}

}
