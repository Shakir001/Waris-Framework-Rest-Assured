package practice1;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.EmployeeDetails;

public class SerializationTwoPhone {
	
	
	@Test
	public void employee() {
		
		long []phone= {9988776607l,8877554493l};
		
		EmployeeDetails emp = new EmployeeDetails("M S DHONI", 45, phone);
		ObjectMapper omap = new ObjectMapper();
		
		try {
			omap.writeValue(new File("./Emp.json"), emp);
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
