package parameter;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PathParameter {
	
	@Test
	public void singleProject() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given()
		.pathParam("pid", "TY_PROJ_5609")
		
		.when()
		.get("/projects/{pid}")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void update() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		JSONObject j = new JSONObject();
		j.put("createdBy", "rohan");
		j.put("projectName", "cricket");
		
		given()
		.pathParam("pid", "TY_PROJ_5609")
		.body(j)
		.contentType(ContentType.JSON)
		
		.when()
		.put("/projects/{pid}")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void delete() {
		
		baseURI = "http://rmgtestingserver";
		port =  8084;
		
		given()
		.pathParam("pid", "TY_PROJ_5609")
		
		.when()
		.delete("projects/{pid}")
		
		.then()
		.assertThat()
		.statusCode(204)
		.contentType(ContentType.JSON)
		.log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
	}

}
