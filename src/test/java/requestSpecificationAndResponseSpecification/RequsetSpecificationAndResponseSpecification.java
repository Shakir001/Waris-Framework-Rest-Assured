package requestSpecificationAndResponseSpecification;

import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoClass.CreateProject;

import static io.restassured.RestAssured.*;

public class RequsetSpecificationAndResponseSpecification {
	
	
	@Test
	public void demo() {
		
		CreateProject s = new CreateProject("ramesh", "board", "done", 10);
		
		 RequestSpecification req = new RequestSpecBuilder()
				 .setBaseUri("http://rmgtestingserver:8084")
				 .setContentType(ContentType.JSON).build();
		 
		 ResponseSpecification resp = new ResponseSpecBuilder()
				 .expectContentType(ContentType.JSON)
				 .expectStatusCode(201).build();
		 
		 given()
		 .spec(req)
		 .body(s)
		 
		 .when()
		 .post("/addProject")
		 
		 
		 .then()
		 .spec(resp)
		 .log()
		 .all();
	}

}
