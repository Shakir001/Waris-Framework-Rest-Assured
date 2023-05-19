package practice;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoClassPractice.Demo;
import pojoClassPractice.Products;

public class Serialization {
	
	@Test
	public void get() {
		
		String []size= {"s","m","xl"};
	
		Products p = new Products("levis", 100, size);
		
		
		Demo d = new Demo("parts", p);
		
		ObjectMapper o = new ObjectMapper();
		try {
			o.writeValue(new File("./Emp.json"), d);
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
