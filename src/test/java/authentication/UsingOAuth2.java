package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UsingOAuth2 {

	
	@Test
	public void fetch() {
		
		baseURI = "http://coop.apps.symfonycasts.com";
		
		Response res = given()
		.formParam("client_id", "SDET47")
		.formParam("client_secret", "92bd8658420f387429257975afc79608")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://www.tyss.com")
		.formParam("code", "authorization_code")
		.when()
		.post("/token");
		
		String token = res.jsonPath().get("access_token");
		System.out.println(token);
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 4510)
		
		
		.when()
		.post("/api/{USER_ID}/eggs-count")
		
		.then()
		.log().all();
		
		
	}
}
