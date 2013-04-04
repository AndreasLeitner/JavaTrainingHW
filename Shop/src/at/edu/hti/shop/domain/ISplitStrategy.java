package at.edu.hti.shop.domain;

import java.util.ArrayList;

public interface ISplitStrategy {

	public void split(Order order, ArrayList<OrderLine> orderLines);
	
}
