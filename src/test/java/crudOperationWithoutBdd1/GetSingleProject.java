package crudOperationWithoutBdd1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {
	
	
	@Test
	public void getSigleProject() {
		
		//perform action
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_5332");
		
		// validate
		int res = response.statusCode();
		
		response.then().log().all();
		Assert.assertEquals(200, res);
		
	}

}
