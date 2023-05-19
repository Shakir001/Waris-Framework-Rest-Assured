package crudOperationWithBdd1;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class DeleteProject {
	
	@Test
	public void delete() {
		
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		when()
		.delete("/projects/TY_PROJ_3636")
		
		.then()
		
		.contentType(ContentType.JSON)
		.statusCode(204)
		.log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
	}

}
