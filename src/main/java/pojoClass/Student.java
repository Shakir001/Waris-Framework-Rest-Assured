package pojoClass;

public class Student {
	
	
	String name;
	int stid;
	long mob;
	String sub;
	
	public Student(String name, int stid, long mob, String sub) {
		
		this.name=name;
		this.stid=stid;
		this.mob=mob;
		this.sub=sub;
	}
	
	public Student() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStid() {
		return stid;
	}

	public void setStid(int stid) {
		this.stid = stid;
	}

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	
}
