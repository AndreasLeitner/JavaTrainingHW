package at.edu.hti.shop.domain;

public class SubOrder extends Order {

	public SubOrder(ICalcPrice priceStrategy){
		this.priceStrategy = priceStrategy;
	}
	
	public double calcPrize() {
	
	  return priceStrategy.calcPrice(orderList);
	}
	
	@Override
	public String toString() {

		return "SubOrder [" +orderList.toString() + "  =>" + calcPrize();
	}

}
