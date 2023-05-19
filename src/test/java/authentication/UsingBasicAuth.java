package authentication;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class UsingBasicAuth {
	
	@Test
	public void basic() {
		
		baseURI = "http://rmgtestingserver";
		port =8084;
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		
		
		.when()
		.get("/login")
		
		.then()
		.assertThat()
		.statusCode(202)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS)
		.log().all();
	}
	
	//Second way if we login each and every time
	@Test
	public void digest() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then()
		.assertThat()
		.statusCode(202)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS)
		.log().all();
	}
	
	//third way
	@Test
	public void preemtiveBasicAuth() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then()
		.assertThat()
		.statusCode(202)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS)
		.log().all();
	}

}
