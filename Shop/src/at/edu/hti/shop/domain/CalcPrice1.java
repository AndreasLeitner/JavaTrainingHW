package at.edu.hti.shop.domain;

import java.util.ArrayList;

public class CalcPrice1 implements ICalcPrice {
	
	private static double SHIPPING_COSTS = 5;
	
	@Override
	public double calcPrice(ArrayList<OrderLine> orderLines) {
		double sum = 0;
		for (OrderLine line : orderLines){
			sum += line.getProduct().getPrize()* line.getAmount() ;
		}
		
		if (sum < 10){
			return sum+SHIPPING_COSTS;
		}
		
		return sum;
		
	}

}
