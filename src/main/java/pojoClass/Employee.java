package pojoClass;

public class Employee {

	String name;
	int empid;
	int phone;
	
	public Employee(String name, int empid, int phone) {
		
		this.name=name;
		this.empid=empid;
		this.phone=phone;	
	}
	
	public Employee() {
		
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
}
