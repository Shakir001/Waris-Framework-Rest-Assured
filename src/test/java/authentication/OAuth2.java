package authentication;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class OAuth2 {
	
	@Test
	public void validate() {
		
		baseURI = "http://coop.apps.symfonycasts.com";
		
		Response res = given()
		.formParam("client_id", "TYSS INDIA")
		.formParam("client_secret", "552fc655f579ceda6a1b4ac57ebcb089")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://www.qspider.com")
		.formParam("code", "authorization_code")
		.when()
		.post("/token");
		
		String token = res.jsonPath().getString("access_token");
		
		given()
		.auth().oauth2(token)
		.pathParam("id", 4510)
		
		.when().post("/api/{id}/eggs-count")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS)
		.log().all();
		

	}
}
