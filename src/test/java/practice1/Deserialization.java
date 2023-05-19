package practice1;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.Employee;

public class Deserialization {
	
	@Test
	public void deserialization() {
		
		
		ObjectMapper omap = new ObjectMapper();
		Employee data= null;
		try {
			data=omap.readValue(new File("./Emp.json"), Employee.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(data.getName()+" "+data.getEmpid()+" "+data.getPhone());
	}

}
