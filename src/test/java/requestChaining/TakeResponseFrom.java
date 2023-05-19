package requestChaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class TakeResponseFrom  {
	
	@Test
	public void d() {
		
		RequestChaining r = new RequestChaining();
		
		r.chaining();
		System.out.println(r.pid);
		
		
		given()
		.pathParam("p", r.pid)
	
		.when()
		.get("/projects/{p}")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS)
		.log().all();	
	}
}
