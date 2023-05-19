package complexDat;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass1.CustomerDetails;
import pojoClass1.SpouseDetails;

public class CustomerSerialization {
	
	
	@Test
	public void serialization() {
		
		long []phone= {9988007711l, 8899334488l};
		long []mob = {8800992233l, 6233449900l};
		
		SpouseDetails spouse = new SpouseDetails("K M", "house wife", mob);
		CustomerDetails c = new CustomerDetails("mohit", 99, phone, spouse);
		
		ObjectMapper o = new ObjectMapper();
		try {
			o.writeValue(new File("./Emp.json"), c);
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
