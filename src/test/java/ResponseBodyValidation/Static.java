package ResponseBodyValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Static {
	
	@Test
	public void sta() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		String expData = "TY_PROJ_3646";
		
		Response res = when()
		.get("/projects");
		
		String actData = res.jsonPath().get("[0].projectId");
		
		Assert.assertEquals(expData, actData);
		res.then().log().all();
		
		
	}

}
