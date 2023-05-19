package crudOperationWithBdd;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class DeleteProject {
	
	@Test
	public void deleteProject() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		when()
		.delete("/projects/TY_PROJ_4678")
		
		.then()
		.contentType(ContentType.JSON)
		.log().all()
		.statusCode(204).time(Matchers.lessThan(2000l), TimeUnit.MILLISECONDS);
	}

}
