package practice1;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.Employee;

public class EmployeeSerialization {

	@Test
	public void employ()  {
		
		Employee emp = new Employee("mohan", 92, 998877665);
		ObjectMapper  omap = new ObjectMapper();
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
