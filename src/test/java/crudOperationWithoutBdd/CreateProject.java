package crudOperationWithoutBdd;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	@Test
	public void createProject() {
		
		JSONObject j = new JSONObject();
		j.put("createdBy", "vinay");
		j.put("projectName", "Bajaj Pulsar 150");
		j.put("status", "done");
		j.put("teamSize", 10);
		
		RequestSpecification req = RestAssured.given();
		req.body(j);
		req.contentType(ContentType.JSON);
		
		Response response = req.post("http://rmgtestingserver:8084/addProject");
		
		int res = response.statusCode();
		System.out.println(response.contentType());
//		System.out.println(response.prettyPrint());
//		System.out.println(response.print());
		System.out.println(response.asString());
		
		Assert.assertEquals(201, res);
		
	}

}
