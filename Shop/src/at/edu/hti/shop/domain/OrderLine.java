package at.edu.hti.shop.domain;

public class OrderLine {
	private Product product;
	private int amount;

	public OrderLine(Product product, int amount) {
		super();
		this.product = product;
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public double calcPrize()
	{
		return amount*product.getPrize();
	}

	@Override
	public String toString() {
		return "OrderLine [" + product + ", " + amount + "]";
	}
	
}
