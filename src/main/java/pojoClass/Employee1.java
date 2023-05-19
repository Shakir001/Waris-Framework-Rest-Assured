package pojoClass;

public class Employee1 {

	String name;
	int empid;
	Spouse sp;

	public Employee1(String name, Spouse sp, int empid) {
		this.name = name;
		this.sp = sp;
		this.empid = empid;
	}

	public Employee1() {

	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public Spouse getSp() {
		return sp;
	}

	public void setSp(Spouse sp) {
		this.sp = sp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
