package crudOperationWithoutBdd1;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
	@Test
	public void updateProject() {
		
		JSONObject j = new JSONObject();
		j.put("createdBy", "mohan");
		j.put("projectName", "XYLEM");
		
		RequestSpecification req = RestAssured.given();
		req.body(j);
		req.contentType(ContentType.JSON);
		
		Response response = req.put("http://rmgtestingserver:8084/projects/TY_PROJ_5332");
		
		int res = response.statusCode();
		
		response.then().log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
		Assert.assertEquals(200, res);
	}

}
