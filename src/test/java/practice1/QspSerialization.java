package practice1;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass1.QspStudent;

public class QspSerialization {
	
	@Test
	public void qsp() {
		
		long []mob= {9988776653l,9900224455l};
		ObjectMapper o = new ObjectMapper();
		QspStudent q = new QspStudent("wasim", mob, "testing");
		
		try {
			o.writeValue(new File("./Emp.json"), q);
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
