package complexDat;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoClass1.CustomerDetails;

public class CustomerDeSerialization {

	@Test
	public void deserialization() {

		ObjectMapper o = new ObjectMapper();
		CustomerDetails data = null;
		try {
			data = o.readValue(new File("./Emp.json"), CustomerDetails.class);
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

		System.out.println(data.getName() + " " + data.getId() + " " + data.getPhone()[0] + " " + data.getPhone()[1]);
		System.out.println(data.getSpouse().getSname() + " " + data.getSpouse().getOccupation() + " "
				+ data.getSpouse().getMob()[0] + " " + data.getSpouse().getMob()[1]);

	}

}
