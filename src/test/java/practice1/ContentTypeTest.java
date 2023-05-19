package practice1;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ContentTypeTest {
	
	@Test
	public  void demo() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		Random r = new Random();
		int random = r.nextInt(100);
		JSONObject j = new JSONObject();
		j.put("createdBy", "rohit");
		j.put("projectName", "mobile"+random);
		
		given()
		.body(j)
		//.contentType(ContentType.JSON)
		
		
		
		.when()
		.put("/projects/TY_PROJ_6222")
		
		.then()
		.assertThat().log().all();
	}

}
