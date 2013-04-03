package at.edu.hti.shop.domain;

import java.util.ArrayList;

public class Order {

	protected ArrayList<OrderLine> orderList = new ArrayList<OrderLine>();
	protected ICalcPrice priceStrategy;
	private ISplitStrategy splitStrategy;
	private ArrayList<SubOrder> subOrders;

	public Order(){
		
	}
	
	public Order(ICalcPrice calcPriceStrategy, ISplitStrategy splitStrategy){
		this.priceStrategy = calcPriceStrategy;
		this.splitStrategy = splitStrategy;
	}
	
	public SubOrder createSubOrder(){
		SubOrder subOrder = new SubOrder(priceStrategy);
		subOrders.add(subOrder);
		return subOrder;
	}
	
	public boolean add(OrderLine e) {

		if (e == null)
			return false;
		
		orderList.add(e);
		
		// calculate each time the splitting again
		if(this.getClass().getSimpleName().equals("Order")){
			subOrders = new ArrayList<>();
			splitStrategy.split(this,orderList);
		}
		return true;

	}

	public int size() {
		return orderList.size();
	}

	public void setAmount(OrderLine e, int amount) {
		boolean remove = false;
		for (OrderLine ol : orderList) {
			if (ol.equals(e)) {
				if (amount == 0) {
					remove = true;
					break;
				}
				ol.setAmount(amount);
			}
		}
		if(remove){
			orderList.remove(e);
		}
		
		//calculate splitting again
		subOrders = new ArrayList<>();
		splitStrategy.split(this,orderList);
	}

	
	public double calcPrize() {
		double price = 0;
		
		for(SubOrder subOrder : subOrders){
			price += priceStrategy.calcPrice(subOrder.orderList);
		}
			
		return price;
	}

	@Override
	public String toString() {

		return subOrders.toString() + " \n =>" + calcPrize();
	}
}
