package practice;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import pojoClass1.CustomerDetails;
import pojoClass1.SpouseDetails;

public class SerializationCustomerPerform {
	
	@Test
	public void demo() {
		
		
		long [] phone = {9922883377l, 6328376456l}; 
		long [] mob = {9922883344l, 7733007744l};
		SpouseDetails s = new SpouseDetails("jyoti", "house wife", mob);
		CustomerDetails c = new CustomerDetails("java", 7, phone, s);
		
		ObjectMapper o = new ObjectMapper();
		try {
			o.writeValue(new File("./Emp.json"), c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
