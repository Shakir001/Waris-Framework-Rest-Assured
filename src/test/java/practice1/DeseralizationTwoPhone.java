package practice1;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.EmployeeDetails;

public class DeseralizationTwoPhone {
	
	
	@Test
	public void employee() {
		
		int []phone = {998877443,887766222};
		
		ObjectMapper omap = new ObjectMapper();
		EmployeeDetails data = null;
		try {
			data = omap.readValue(new File("./Emp.json"), EmployeeDetails.class);
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
		
		System.out.println(data.getName()+" "+data.getEmpid());
		for(int i=0;i<phone.length;i++) {
			System.out.println(data.getPhone()[i]);
		}
	}
	

}
