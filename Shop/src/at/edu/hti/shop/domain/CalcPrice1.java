package at.edu.hti.shop.domain;


public class CalcPrice1 implements ICalcPrice {
	
	private static double SHIPPING_COSTS = 5;
	
	public double calcPrice(Order order) {
		double sum = 0;
		
		for (OrderLine line : order.getLines()){
			sum += line.getProduct().getPrize()* line.getAmount() ;
		}
		
		if (sum < 10){
			return sum+SHIPPING_COSTS;
		}
		
		return sum;
		
	}

}
