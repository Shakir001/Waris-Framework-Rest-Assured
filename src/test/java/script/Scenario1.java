package script;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericLibrary.BaseAPIClass;
import genericLibrary.IconstantPath;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Scenario1 extends BaseAPIClass{
	
	
	@Test
	public void data() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		String projectName="bag"+jLib.getRandom();
		JSONObject j = new JSONObject();
		j.put("createdBy", "wasim");
		j.put("projectName", projectName);
		
		Response res = given()
		.body(j)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
		String projectId  = res.jsonPath().get("projectId");
	    System.out.println(projectId);
		String query ="select * from project";
		
		String status = dLib.readDataFromDatabaseAndValidate(query, 1, projectId);
		System.out.println(status);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(IconstantPath.baseUri);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("usernmae")).sendKeys(IconstantPath.rmg_id);
		driver.findElement(By.id("inputPassword")).sendKeys(IconstantPath.rmg_password);
		driver.findElement(By.xpath("//button[.='Sign in']")).click();

		driver.findElement(By.xpath("//a[.='Projects']")).click();
		
		driver.findElement(By.xpath("//td[.='"+projectId+"']/parent::tr/descendant::i[@title=\"Delete\"]")).click();
		
		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
		
	}
}
