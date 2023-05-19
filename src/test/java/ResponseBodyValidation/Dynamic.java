package ResponseBodyValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class Dynamic {
	
	@Test
	public void dynamic() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		String expData="TY_PROJ_3650";
		Response res = when()
		.get("/projects");
		
		List<String> alldata = res.jsonPath().get("projectId");
		boolean flag = false;
		for (String str : alldata) {
			if(str.equalsIgnoreCase(expData)) {
				flag=true;
			}
		}
		Assert.assertTrue(flag);
		res.then().log().all();
	}

}
