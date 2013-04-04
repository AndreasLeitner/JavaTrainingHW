package at.edu.hti.shop.domain;

public class ToolProduct extends Product {

	public ToolProduct(long id, String name, double prize, double weight, int deliveryTime) {
		super(id, name, prize, weight, deliveryTime);
	}
	
	@Override
	public String toString() {
		return "ToolProduct [" + name + ", " + id + ", " + prize + ", " + weight + ", " + deliveryTime + "]";
	}
	
	

}
