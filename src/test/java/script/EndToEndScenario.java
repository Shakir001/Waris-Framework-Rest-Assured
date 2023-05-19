package script;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibrary.BaseAPIClass;
import genericLibrary.EndPointLibrary;
import io.restassured.response.Response;
import pojoClassForEndToEndScenario.CreateProject;

public class EndToEndScenario extends BaseAPIClass {

	@Test
	public void scenario() {

		CreateProject cus = new CreateProject("mohan", "laptop" + jLib.getRandom(), "on going", 10);

		Response res = given().spec(req).body(cus).when().post(EndPointLibrary.createProject);

		String projectId = rLib.getJsonData("projectId", res);

		String exp = dLib.readDataFromDatabaseAndValidate(pLib.fetchDataFromPropertyFile("query"), 1, projectId);

		Assert.assertEquals(projectId, exp);

		res.then().spec(resp).log().all();

	}

}
