package crudOperationWithoutBdd;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {
	
	
	@Test
	public void getSingleProject() {
		
		
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_5219");
		
		int res = response.statusCode();
		response.then().log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
		Assert.assertEquals(200, res);
		
	}

}
