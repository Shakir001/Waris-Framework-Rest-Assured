package dataDrivenTesting;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class DataDriven {
	
	
	@Test(dataProvider ="data")
	public void getttt(String createdBy, String projectName, String status, int teamSize ) {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		CreateMultipleProjectWithDiffData c = new CreateMultipleProjectWithDiffData(createdBy, projectName, status, teamSize);
		
		given()
		.body(c)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS)
		.log().all();
	}
	
	@DataProvider
	public Object[][] data() {
		
		Object [][] obj = new Object[2][4];
		JavaLibrary ran = new JavaLibrary();
		
		obj[0][0]="dube";
		obj[0][1]="csk"+ran.getRandom();
		obj[0][2]="done";
		obj[0][3]=10;
		
		obj[1][0]="shivam";
		obj[1][1]="kkr"+ran.getRandom();
		obj[1][2]="complete";
		obj[1][3]=12;
		
		return obj;
	}
}
