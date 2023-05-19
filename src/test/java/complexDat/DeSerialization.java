package complexDat;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.Employee1;

public class DeSerialization {

	@Test
	public void employee() {

		ObjectMapper omap = new ObjectMapper();
		Employee1 data = null;
		try {
			data = omap.readValue(new File("./Emp.json"), Employee1.class);
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

		System.out.println(data.getName() + " " + data.getSp().getSname() + " " + data.getEmpid());
		for (int i = 0; i < data.getSp().getPhone().length; i++) {
			System.out.println(data.getSp().getPhone()[i]);
		}
	}
}
