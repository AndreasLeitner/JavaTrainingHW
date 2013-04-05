
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

public class NoSplitStrategy implements ISplitStrategy {

  public void split(Order order) {
    ShippingOrder shippingOrder = order.createShippingOrder();
    for (OrderLine ol : order.getLines()) {
      shippingOrder.add(ol);
    }
  }
}


//---------------------------- Revision History ----------------------------
//$Log$
//
