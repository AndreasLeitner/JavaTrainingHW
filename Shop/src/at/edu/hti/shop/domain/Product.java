package at.edu.hti.shop.domain;

public class Product {
  
  public enum Category {
    FOOD,
    TOOLS,
    NOTEBOOK,
    MISC
  }
  
	protected String name;
	protected long id;
	protected double prize;
	protected int deliveryTime;
	protected double weight;

	public Product( long id, String name, double prize, double weight, int deliveryTime) {
		super();
		this.name = name;
		this.id = id;
		this.prize = prize;
		this.weight = weight;
		this.deliveryTime = deliveryTime;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public double getPrize() {
		return prize;
	}

	public double getWeight() {
	  return weight;
  }

	public int getDeliveryTime() {
	  return deliveryTime;
  }

	public void setDeliveryTime(int deliveryTime) {
	  this.deliveryTime = deliveryTime;
  }
	
	public Category getCategory() {
	  return Category.MISC;
	}

	@Override
	public String toString() {
		return "Product [" + name + ", " + id + ", " + prize + ", " + weight + ", " + deliveryTime + "]";
	}

}
