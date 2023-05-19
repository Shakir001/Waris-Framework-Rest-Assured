package differentWayToPostARequest;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojoClass.Customer;

public class ThroughPojoClassPostARequest {
	
	
	@Test
	public void customer() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		Customer cu = new Customer("sunil kumar", "Cricket", "done", 10);
		
		given()
		.body(cu)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
		
	}

}
