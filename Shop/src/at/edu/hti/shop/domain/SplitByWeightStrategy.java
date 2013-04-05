package at.edu.hti.shop.domain;


public class SplitByWeightStrategy implements ISplitStrategy {

	private final double max_weight;
	
	public SplitByWeightStrategy(double max_weight) {
		this.max_weight = max_weight;
	}

	public void split(Order order) {
		double subOrderWeight = 0;
		double weight;
		SubOrder currSubOrder = order.createSubOrder();
		for(OrderLine ol : order.getLines()){
			weight = ol.getAmount() * ol.getProduct().getWeight();
						
			subOrderWeight += weight;
			
			if(subOrderWeight < max_weight || weight > max_weight){
				currSubOrder.add(ol);
			} else {
			  System.out.println("Create new suborder because current suborderweight="+subOrderWeight);
				currSubOrder = order.createSubOrder();
				subOrderWeight = weight;
				currSubOrder.add(ol);
			}
		}
	}
		
	
}
