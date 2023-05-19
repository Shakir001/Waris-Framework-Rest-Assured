package genericLibrary;


import io.restassured.response.Response;

public class RestAssuredLibrary {

	public String getJsonData(String path, Response response) {

		String jsonData = response.jsonPath().get(path);

		return jsonData;
		
	}
}
