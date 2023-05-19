package ResponseBodyValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StaticResponseValidation {
	
	@Test
	public void response() {
		
		String expData="TY_PROJ_3632";
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		Response resp = when()
		.get("/projects");
		
		String actData = resp.jsonPath().get("[1].projectId");
		Assert.assertEquals(expData, actData);
		
		resp.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS)
		.log().all();
		
	}

}
