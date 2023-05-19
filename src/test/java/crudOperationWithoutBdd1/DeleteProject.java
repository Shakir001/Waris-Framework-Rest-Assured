package crudOperationWithoutBdd1;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	
	@Test
	public void deleteProject() {
		
		Response response = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_5332");
		
		int res = response.statusCode();
		response.then().log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
		Assert.assertEquals(204, res);
	}
}
