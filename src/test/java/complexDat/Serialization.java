package complexDat;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.Employee1;
import pojoClass.Spouse;

public class Serialization {

	@Test
	public void employee() {

		long[] phone = { 9988334408l, 1199330023l };
		Spouse sp = new Spouse("dp", phone);
		Employee1 emp = new Employee1("rohit", sp, 98);
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
