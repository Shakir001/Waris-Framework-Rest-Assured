package ResponseBodyValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseInRequres {
	
	@Test
	public void java() {
		
		baseURI ="https://reqres.in";
		int exp=7;
		
		Response res = when()
		.get("/api/users?page=2");
		boolean flag=false;
		List<Integer> act = res.jsonPath().get("data.id");
		System.out.println(act);
		
		for (Integer str : act) {
			if(str==exp) {
				flag=true;
			}
		}
		
		Assert.assertTrue(flag);
		res.then().log().all();
		
		
	}

}
