
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

public class FoodProduct extends Product {
  public FoodProduct(long id, String name, double prize, double weight, int deliveryTime) {
    super(id, name, prize, weight, deliveryTime);
  }
  
  @Override
  public Category getCategory() {
    return Category.FOOD;
  }

  @Override
  public String toString() {
    return "FoodProduct [" + name + ", " + id + ", " + prize + ", " + weight + ", " + deliveryTime + "]";
  }
}


//---------------------------- Revision History ----------------------------
//$Log$
//
