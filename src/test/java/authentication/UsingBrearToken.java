package authentication;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class UsingBrearToken {
	
	@Test
	public void bearerToken() {
		
		baseURI = "https://api.github.com";
		
		JSONObject j = new JSONObject();
		j.put("name", "ResrAssured1");
		
		given()
		.auth().oauth2("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")
		.body(j)
		.contentType(ContentType.JSON)
		
		
		.when()
		.post("/user/repos")
		
//		String p = res.jsonPath().get("name");
//		System.out.println(p);
//		
//	
//		 given()
//		.auth().oauth2("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")
//	    .pathParam("id", p)
//	    
//	    .when()
//	    .delete("/repos/johncena-5/{id}")
		
		.then()
		.assertThat()
		.statusCode(204)
		//.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS)
		.log().all();
	}

}
