package crudWithoutBdd;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Create {
	
	@Test
	public void creat() {
		
		JSONObject j = new JSONObject();
		j.put("name", "vinay");
		j.put("job", "software engineer");
		
		RequestSpecification req = RestAssured.given();
		req.body(j);
		req.contentType(ContentType.JSON);
		
		Response response = req.post("https://reqres.in/api/users");
		
		int res = response.statusCode();
		System.out.println(response.contentType());
		System.out.println(response.prettyPrint());
		System.out.println(response.print());
		
		Assert.assertEquals(201, res);
		
		
		
	}

}
