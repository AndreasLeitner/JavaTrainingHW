package at.edu.hti.shop;

import at.edu.hti.shop.domain.CalcPrice1;
import at.edu.hti.shop.domain.NoShippingCostsCalcPrice;
import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.domain.SplitByWeightStrategy;
import at.edu.hti.shop.domain.ToolProduct;

public class App {
	public static void main(String[] args) {

		Order shopOrder = new Order(new NoShippingCostsCalcPrice(), new SplitByWeightStrategy(50.0));

		OrderLine line1 = new OrderLine(new Product(1, "Äpfel", 1.2, 4, 0), 4);
		OrderLine line2 = new OrderLine(new Product(2, "Birnen", 1.5, 2, 0), 2);

		OrderLine line3 = new OrderLine(new Product(3, "Pfirsich", 2.2, 0, 0), 5);
		OrderLine line4 = new OrderLine(new Product(4, "Kiwi", 3.5, 0, 0), 6);
		OrderLine line5 = new OrderLine(new ToolProduct(5, "Knife", 8.0, 0, 0), 1);

		shopOrder.add(line1);
		shopOrder.add(line2);
		System.out.println("Lines: "+shopOrder.size());
		System.out.println(shopOrder);

		shopOrder.setAmount(line1,8);

    System.out.println("Lines: "+shopOrder.size());
		System.out.println(shopOrder);

		shopOrder.setAmount(line2,0);

    System.out.println("Lines: "+shopOrder.size());
		System.out.println(shopOrder);

		shopOrder.setAmount(line1,1);
		shopOrder.add(line3);
		shopOrder.add(line4);
		shopOrder.add(line5);

    System.out.println("Lines: "+shopOrder.size());
		System.out.println(shopOrder);
		
	}
}
