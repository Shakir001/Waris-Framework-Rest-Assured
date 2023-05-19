package genericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseLibrary {
	
	Connection con;
	Driver driverR;
	
	public void connectToDb()  {
		
		try {
			driverR = new Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(driverR);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(IconstantPath.database_url,IconstantPath.database_username,IconstantPath.database_password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeDB()  {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String readDataFromDatabaseAndValidate(String query, int columnIndex, String expData)  {
		
		boolean flag = false;
		ResultSet result = null;
		try {
			result = con.createStatement().executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			while(result.next()) {
				if(result.getString(columnIndex).equalsIgnoreCase(expData)) {
					flag = true;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(flag) {
			System.out.println("verified");
			return expData;
		}else {
			System.out.println("data not verified");
			return "";
		}
	}
}
