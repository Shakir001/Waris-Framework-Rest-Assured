package pojoClassPractice;

public class Products {
	
	String productName;
	int productid;
	String [] Size;
	
	public Products(String productName, int productid, String []Size) {
		this.productName=productName;
		this.productid=productid;
		this.Size=Size;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public int getProductid() {
		return productid;
	}
	
	public String [] getSize() {
		return Size;
	}

}
