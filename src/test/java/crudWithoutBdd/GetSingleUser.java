package crudWithoutBdd;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleUser {
	
	
	@Test
	public void get() {
		
		Response response = RestAssured.get("https://reqres.in/api/users/2");
		
		int res = response.statusCode();
		System.out.println(res);
		System.out.println(response.contentType());
		System.out.println(response.print());
		
		Assert.assertEquals(200, res);
		
		
		
		
	}

}
