package dataDrivenTesting;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class DataDrivenTesting {
	
	@Test(dataProvider = "data")
	public void getData(String createdBy, String projectName) {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		PojoClass p = new PojoClass(createdBy, projectName);
		
		given()
		.body(p)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
//		.assertThat()
//		.statusCode(201)
//		.contentType(ContentType.JSON)
//		.time(Matchers.lessThan(1000l), TimeUnit.SECONDS)
		.log().all();
		
	}

	
	@DataProvider
	public Object[][] data() {
		
		Object [][] obj = new Object[1][2];
		
		obj[0][0]="manju";
		obj[0][1]="flight";
		
		return obj;
	}
}
