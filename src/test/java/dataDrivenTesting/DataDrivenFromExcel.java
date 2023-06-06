package dataDrivenTesting;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataDrivenFromExcel {
	
	@Test(dataProvider = "data")
	public void fetch(String createdBy, String projectName, String status, String teamSize) {
		
		baseURI="http://rmgtestingserver";
		port = 8084;
		
		Pojo p = new Pojo(createdBy, projectName, status, teamSize);
		
		given()
		.body(p)
		.contentType(ContentType.JSON)
		
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS)
		.log().all();

	}
	
	
	@DataProvider
	public Object[][] data() throws Throwable {
		
		FileInputStream fis = new FileInputStream(".//src/test/resources/DataDriven.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh =wb.getSheet("Sheet1");
		int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		
		Object [][]obj = new Object[lastrow][lastcell];
		for(int i=0; i<lastrow;i++) {
			for(int j=0;j<lastcell;j++) {
				obj[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
				
				
			}
		}
		return obj;
		
		
		
	}

}
