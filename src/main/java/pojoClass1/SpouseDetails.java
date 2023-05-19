package pojoClass1;

public class SpouseDetails {
	
	
	String sname;
	String occupation;
	long []mob;
	
	public SpouseDetails(String sname, String occupation, long []mob) {
		this.mob=mob;
		this.sname=sname;
		this.occupation=occupation;
		
	}
	
	public SpouseDetails() {
		
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public long[] getMob() {
		return mob;
	}

	public void setMob(long[] mob) {
		this.mob = mob;
	}
	
	

}
