
/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package at.edu.hti.shop.domain;


/**
 * This is the class header. The first sentence (ending with "."+SPACE) is important,
 * because it is used summary in the package overview pages.<br />
 * <br />
 *
 *
 * @author  jog
 * @version $Revision$
 */

public class EveryShipmentShippingFeeCalcPrice implements ICalcPrice {

  private double shippingFee = 0;
  
  public EveryShipmentShippingFeeCalcPrice(double shippingFee) {
    this.shippingFee=shippingFee;
  }
  
  public double calcPrice(Order order) {
    double sum = 0;
    
    for (OrderLine line : order.getLines()){
      sum += line.getProduct().getPrize()* line.getAmount() ;
    }
    sum += order.getShippingOrders().size()*shippingFee;
    
    return sum;
  }

}


//---------------------------- Revision History ----------------------------
//$Log$
//
