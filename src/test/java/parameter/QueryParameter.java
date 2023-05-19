package parameter;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class QueryParameter {
	
	@Test
	public void query() {
		
		baseURI = "https://reqres.in";
		
		
		given()
		.queryParam("page", 2)
		
		.when()
		.get("/api/users")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all().time(Matchers.lessThan(2000l), TimeUnit.MILLISECONDS);
		
	}

}
