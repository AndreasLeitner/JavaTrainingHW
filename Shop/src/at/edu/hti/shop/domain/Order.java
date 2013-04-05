package at.edu.hti.shop.domain;

import java.util.ArrayList;

import at.edu.hti.shop.domain.specification.ISpecification;

public class Order {

	protected ArrayList<OrderLine> orderList = new ArrayList<OrderLine>();
	protected ICalcPrice priceStrategy;
  private ISplitStrategy splitStrategy;
  private ArrayList<SubOrder> subOrders;

	public Order() {
	  subOrders = new ArrayList<SubOrder>();
	}
	
	public Order(ICalcPrice calcPriceStrategy, ISplitStrategy splitStrategy){
		this.priceStrategy = calcPriceStrategy;
		this.splitStrategy = splitStrategy;
    subOrders = new ArrayList<SubOrder>();
	}
	
  public SubOrder createSubOrder(){
    SubOrder subOrder = new SubOrder(priceStrategy);
    subOrders.add(subOrder);
    return subOrder;
  }
	
	public ArrayList<OrderLine> getLines() {
	  return orderList;
	}
	
	public boolean add(OrderLine e) {

		if (e == null)
			return false;
		
		orderList.add(e);
		
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
	}

	protected void split() {
	  splitStrategy.split(this);
	}
	
	
	public double calcPrize() {
		double price = 0;

		split();
		
		price = priceStrategy.calcPrice(this);
		
		return price;
	}

	@Override
	public String toString() {
	  split();
	  return subOrders.toString() + " \n Total price =>" + calcPrize();
	}
	
	public double getWeight() {
	  double weight = 0;
	  for (OrderLine ol : orderList) {
	    weight = weight+ol.getProduct().getWeight();
	  }
	  return weight;
	}
}
