package differentWayToPostARequest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import pojoClass.Customer;
import pojoClass.Worker;

public class PostARequestUsingTwoWay {
	
	@Test
	public void df() {
		
		//post a request using json file and pojo class
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JavaLibrary r = new JavaLibrary();
		Customer c = new Customer("rohit", "Air India"+r.getRandom(), "done", 10);
		ObjectMapper o = new ObjectMapper();
		try {
			o.writeValue(new File("./Emp.json"), c);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		given()
		.body(new File("./Emp.json"))
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);	
	}
}
