package pojoClass1;

public class QspStudent {
	
	String name;
	long []mob;
	String course;
	
	public QspStudent(String name, long []mob, String course) {
		this.name=name;
		this.mob=mob;
		this.course=course;
	}
	
	public QspStudent() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long[] getMob() {
		return mob;
	}

	public void setMob(long[] mob) {
		this.mob = mob;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	

}
