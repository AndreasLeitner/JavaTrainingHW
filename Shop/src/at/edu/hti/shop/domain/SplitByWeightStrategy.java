package at.edu.hti.shop.domain;


public class SplitByWeightStrategy implements ISplitStrategy {

	private final double max_weight;
	
	public SplitByWeightStrategy(double max_weight) {
		this.max_weight = max_weight;
	}

	public void split(Order order) {
		double subOrderWeight = 0;
		double weight;
		ShippingOrder currSubOrder = order.createShippingOrder();
		for(OrderLine ol : order.getLines()){
			weight = ol.getAmount() * ol.getProduct().getWeight();
						
			subOrderWeight += weight;
			
			if(subOrderWeight < max_weight || weight > max_weight){
				currSubOrder.add(ol);
			} else {
				currSubOrder = order.createShippingOrder();
				subOrderWeight = weight;
				currSubOrder.add(ol);
			}
		}
	}
		
	
}
