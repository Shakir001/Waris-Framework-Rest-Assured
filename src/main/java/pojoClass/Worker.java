package pojoClass;

public class Worker {

	
	String wname;
	int wid;
	long wphone;
	
	public Worker(String wname, int wid, long wphone) {
		this.wname=wname;
		this.wid=wid;
		this.wphone=wphone;
	}
	
	public Worker() {
		
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public long getWphone() {
		return wphone;
	}

	public void setWphone(long wphone) {
		this.wphone = wphone;
	}
	
	
}
