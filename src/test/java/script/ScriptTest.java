package script;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibrary.BaseAPIClass;
import genericLibrary.EndPointLibrary;
import io.restassured.response.Response;
import pojoClass.CreateProject;

public class ScriptTest extends BaseAPIClass {

	@Test
	public void scenario() {

		String ProjectName = "laptop" + jLib.getRandom();
		CreateProject cus = new CreateProject("mohan", ProjectName, "on going", 10);

		Response res = given().spec(req).body(cus).when().post(EndPointLibrary.createProject);

		String projectId = rLib.getJsonData("projectId", res);

		String exp = dLib.readDataFromDatabaseAndValidate(pLib.fetchDataFromPropertyFile("query"), 1, projectId);

		Assert.assertEquals(projectId, exp);

		login.loginToApplication(pLib.fetchDataFromPropertyFile("username"),
				pLib.fetchDataFromPropertyFile("password"));

		home.clickProjectModuel();

		String act = driver.findElement(By.xpath("//td[.='" + ProjectName + "']/preceding-sibling::td")).getText();

		Assert.assertEquals(act, exp);
	}

}
