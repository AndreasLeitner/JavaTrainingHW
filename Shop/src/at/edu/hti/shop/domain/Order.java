package at.edu.hti.shop.domain;

import java.util.ArrayList;

public class Order {

	protected ArrayList<OrderLine> orderList = new ArrayList<OrderLine>();
	protected ICalcPrice priceStrategy;
  private ISplitStrategy splitStrategy;
  private ArrayList<ShippingOrder> shippingOrders;

	public Order() {
	  shippingOrders = new ArrayList<ShippingOrder>();
	}
	
	public Order(ICalcPrice calcPriceStrategy, ISplitStrategy splitStrategy){
		this.priceStrategy = calcPriceStrategy;
		this.splitStrategy = splitStrategy;
    shippingOrders = new ArrayList<ShippingOrder>();
	}
	
  public ShippingOrder createShippingOrder(){
    ShippingOrder subOrder = new ShippingOrder(priceStrategy);
    shippingOrders.add(subOrder);
    return subOrder;
  }
	
	public ArrayList<OrderLine> getLines() {
	  return orderList;
	}
	
	public ArrayList<ShippingOrder> getShippingOrders() {
	  return shippingOrders;
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

	private void split() {
//    shippingOrders.clear();
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
	  return shippingOrders.toString() + " \n Total price =>" + calcPrize();
	}
	
	public double getWeight() {
	  double weight = 0;
	  for (OrderLine ol : orderList) {
	    weight = weight+ol.getProduct().getWeight();
	  }
	  return weight;
	}
	
	public void setSplittingStrategy(ISplitStrategy strategy) {
	  this.splitStrategy = strategy;
	  shippingOrders.clear();
	}
}
