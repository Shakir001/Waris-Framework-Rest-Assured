package requestChaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass1.Worker;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class RequestChaining {
	
	String  pid;
	
	public void chaining() {
		
		
		JavaLibrary ran = new JavaLibrary();
		baseURI = "http://rmgtestingserver";
		port = 8084;

		Worker w = new Worker("mohit kumar", "java course"+ran.getRandom(), "going", 10);

		Response res = given()
		.body(w)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");

		pid = res.jsonPath().get("projectId");

		//taking response as a request
		
		given()
		.pathParam("id", pid)
		
		.when()
		.get("/projects/{id}")

		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS)
		.log().all();
	}
}
