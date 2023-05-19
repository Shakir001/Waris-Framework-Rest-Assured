package ResponseBodyValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {

	@Test
	public void dynamic() {

		String expData = "TY_PROJ_3697";
		baseURI = "http://rmgtestingserver";
		port = 8084;

		Response resp = when().get("/projects");

		boolean flag = false;

		List<String> allData = resp.jsonPath().get("projectId");
		for (String str : allData) {

			if (str.equalsIgnoreCase(expData)) {
				flag = true;
			}
		}
		Assert.assertTrue(flag);
		resp.then().log().all();
	}
}
