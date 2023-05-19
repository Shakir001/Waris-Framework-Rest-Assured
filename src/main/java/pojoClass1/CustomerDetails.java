package pojoClass1;

public class CustomerDetails {
	
	String name;
	int id;
	long []phone;
	SpouseDetails spouse;
	
	public CustomerDetails (String name, int id, long []phone, SpouseDetails spouse){
		
		this.name=name;
		this.id=id;
		this.phone=phone;
		this.spouse=spouse;
	}
	
	public CustomerDetails() {
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long[] getPhone() {
		return phone;
	}

	public void setPhone(long[] phone) {
		this.phone = phone;
	}

	public SpouseDetails getSpouse() {
		return spouse;
	}

	public void setSpouse(SpouseDetails spouse) {
		this.spouse = spouse;
	}
	
	

}
