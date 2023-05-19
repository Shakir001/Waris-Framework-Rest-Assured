package practice1;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass1.QspStudent;

public class QspDeserilaztion {
	
	@Test
	public void qsp() {
		
		ObjectMapper o = new ObjectMapper();
		QspStudent data=null;
		try {
			data = o.readValue(new File("./Emp.json"), QspStudent.class);
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
		
		System.out.println(data.getName()+" "+data.getMob()[0]+" "+data.getCourse());
	}

}
