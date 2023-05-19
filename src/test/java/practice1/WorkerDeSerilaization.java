package practice1;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.Worker;

public class WorkerDeSerilaization {
	
	
	@Test
	public void d() {
		
		
		ObjectMapper o = new ObjectMapper();
		Worker data = null;
		try {
			data = o.readValue(new File("./Emp.json"), Worker.class);
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
		System.out.println(data.getWname());
		System.out.println(data.getWid());
		System.out.println(data.getWphone());
	}

}
