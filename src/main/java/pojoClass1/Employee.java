package pojoClass1;

public class Employee {
	
	
	String name;
	int empid;
	long mob;
	
	public Employee(String name, int empid, int mob) {
		this.name=name;
		this.empid=empid;
		this.mob=mob;
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

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
	}
	
	
	
	

}
