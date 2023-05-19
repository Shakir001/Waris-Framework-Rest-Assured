package pojoClass;

public class EmployeeDetails {
	
	String name;
	int empid;
	long [] phone;
	
	public EmployeeDetails(String name, int empid, long[] phone) {
		
		this.name=name;
		this.empid=empid;
		this.phone=phone;
	}
	
	public EmployeeDetails() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public long[] getPhone() {
		return phone;
	}

	public void setPhone(long[] phone) {
		this.phone = phone;
	}
}
