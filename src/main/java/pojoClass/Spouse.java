package pojoClass;

public class Spouse {

	String sname;
	long [] phone;

	public Spouse(String sname, long[] phone) {
		this.sname = sname;
		this.phone = phone;
	}

	public Spouse() {

	}

	public long[] getPhone() {
		return phone;
	}

	public void setPhone(long[] phone) {
		this.phone = phone;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
}
