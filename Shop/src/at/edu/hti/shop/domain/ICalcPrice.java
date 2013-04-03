package at.edu.hti.shop.domain;

import java.util.ArrayList;

public interface ICalcPrice {

	
	public double calcPrice(ArrayList<OrderLine> orderLines);
}
