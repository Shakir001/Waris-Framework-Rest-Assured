package practice1;

import java.io.File;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFObjectData;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import io.restassured.internal.mapping.JsonbMapper;
import pojoClass.Worker;

public class WorkerSerialization {
	
	
	@Test
	public void serial() {
		
		Worker w = new Worker("Sohan kumar", 45, 9977553322l);
		ObjectMapper j = new ObjectMapper();
		
		try {
			j.writeValue(new File("./Emp.json"), w);
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
	}

}
