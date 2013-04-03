package at.edu.hti.shop.domain;

import java.util.ArrayList;

public class Order {

	private static final long serialVersionUID = 1L;
	private ArrayList<OrderLine> orderList = new ArrayList<OrderLine>();
	private ICalcPrice strategy = new CalcPrice1();
	
	public boolean add(OrderLine e) {

		if (e == null)
			return false;

		return orderList.add(e);
	}
	
	public int size() {
		return orderList.size();
	}
	
	public void setAmount(OrderLine e, int amount){
		for(OrderLine ol : orderList){
			if(ol.equals(e)){
				ol.setAmount(amount);
			}
		}
		
	}

	public double calcPrize() {
		return strategy.calcPrice(orderList);
	}

	@Override
	public String toString() {
	
		return orderList.toString() + " \n =>" +calcPrize();
	}
}
