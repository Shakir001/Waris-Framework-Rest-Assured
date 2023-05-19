package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileLibrary {
	
	public String fetchDataFromPropertyFile(String data)  {
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(IconstantPath.property_url);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties p = new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String value = p.getProperty(data);
		
	     return value;
	}

}
