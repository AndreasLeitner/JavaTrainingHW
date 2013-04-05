package at.edu.hti.shop.domain;

public class ShippingOrder extends Order {

	public ShippingOrder(ICalcPrice priceStrategy){
		this.priceStrategy = priceStrategy;
	}
	
	@Override
	public double calcPrize() {
	
	  return priceStrategy.calcPrice(this);
	}
	
	@Override
	public String toString() {
		return "ShippingOrder [" +orderList.toString() + "  =>" + calcPrize();
	}

	
	
}
