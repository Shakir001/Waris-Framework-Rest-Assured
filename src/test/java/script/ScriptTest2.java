package script;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibrary.BaseAPIClass;
import genericLibrary.EndPointLibrary;
import genericLibrary.IconstantPath;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import pojoClass.CreateProject;

public class ScriptTest2 extends BaseAPIClass {

	@Test
	public void demo() {

		CreateProject cus = new CreateProject("mohan", "laptop" + jLib.getRandom(), "on going", 10);

		Response res = given().spec(req).body(cus).when().post(EndPointLibrary.createProject);

		String projectId = rLib.getJsonData("projectId", res);

		String query = "select * from project";

		String act = dLib.readDataFromDatabaseAndValidate(query, 1, projectId);

		Assert.assertEquals(projectId, act);

		//res.then().spec(resp).log().all();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(IconstantPath.baseUri);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("usernmae")).sendKeys(IconstantPath.rmg_id);
		driver.findElement(By.id("inputPassword")).sendKeys(IconstantPath.rmg_password);
		driver.findElement(By.xpath("//button[.='Sign in']")).click();

		driver.findElement(By.xpath("//a[.='Projects']")).click();

		boolean flag = false;
		List<WebElement> data = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getText().equals(projectId)) {
				flag = true;
				break;
			} else {
				flag = false;
			}
		}
		if (flag) {
			System.out.println("verified in gui");
		} else {
			System.out.println("not update");
		}
		
		
	}
}
