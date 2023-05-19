package requestSpecificationAndResponseSpecification;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoClass.Customer;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class RequestAndResponseBuilder {
	
	
	@Test
	public void demo() {
		
		Customer c = new Customer("Sunil", "pen", "start", 11);
		
		 RequestSpecification req = new RequestSpecBuilder()
				 .setBaseUri("http://rmgtestingserver:8084")
				 .setContentType(ContentType.JSON).build();
		 
		 ResponseSpecification resp = new ResponseSpecBuilder()
				 .expectContentType(ContentType.JSON)
				 .expectResponseTime(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS)
				 .expectStatusCode(201).build();
		 
		 given()
		 .spec(req)
		 .body(c)
		 
		 .when()
		 .post("/addProject")
		 
		 .then()
		 .spec(resp)
		 .log().all();
				 
		
	}

}
