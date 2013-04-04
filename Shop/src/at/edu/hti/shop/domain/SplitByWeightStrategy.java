package at.edu.hti.shop.domain;

import java.util.ArrayList;

public class SplitByWeightStrategy implements ISplitStrategy {

	private final double max_weight;
	
	public SplitByWeightStrategy(double max_weight) {
		this.max_weight = max_weight;
	}

	@Override
	public void split(Order order, ArrayList<OrderLine> orderLines) {
		SubOrder currSubOrder = order.createSubOrder();
		double subOrderWeight = 0;
		double weight;
		
		for(OrderLine ol : orderLines){
			weight = ol.getAmount() * ol.getProduct().getWeight();
						
			subOrderWeight += weight;
			
			if(subOrderWeight < max_weight || weight > max_weight){
				currSubOrder.add(ol);
			} else {
				currSubOrder = order.createSubOrder();
				subOrderWeight = weight;
				currSubOrder.add(ol);
			}
		}
	}
		
	
}
