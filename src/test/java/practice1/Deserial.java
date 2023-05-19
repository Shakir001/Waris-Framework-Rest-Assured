package practice1;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.Student;

public class Deserial {
	
	@Test
	public void student() {
		
		ObjectMapper omap = new ObjectMapper();
		Student data=null;
		 try {
			data = omap.readValue(new File("./Emp.json"), Student.class);
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
		 
		 System.out.println(data.getName()+" "+data.getStid()+" "+data.getSub()+" "+data.getMob());	
	}
}
