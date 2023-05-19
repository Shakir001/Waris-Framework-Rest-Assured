package crudOperationWithoutBdd;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProject {
	
	@Test
	public void getAllProject() {
		
		
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects");
		response.then().log().all();
		int res = response.statusCode();
		Assert.assertEquals(200, res);
	}

}
