package parameter;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class FormParameter {
	
	
	@Test
	public void form() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given()
		.formParam("createdBy", "sachin")
		.formParam("projectName", "Icc")
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.time(Matchers.lessThan(2000l), TimeUnit.MILLISECONDS)
		.log().all();
	}
}
