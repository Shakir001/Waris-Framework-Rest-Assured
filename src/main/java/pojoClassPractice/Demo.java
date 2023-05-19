package pojoClassPractice;

public class Demo {
	
	String productCategory;
	Products  products;
	
	public Demo(String productCategory, Products products) {
		this.productCategory=productCategory;
		this.products=products;
	}
	
	public String getProductCategory() {
		return productCategory;
	}
	
	public Products  getProducts() {
		return products;
	}

}
