package crudOperationWithoutBdd1;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getAllProject {
	
	
	@Test
	public void getAllProject() {
		
		
		 Response response = RestAssured.get("http://rmgtestingserver:8084/projects");
		 
		 int res = response.statusCode();
		 response.then().log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
		 Assert.assertEquals(200, res);
		 
	}

}
