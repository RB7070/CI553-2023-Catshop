package catalogue;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

/**
 * The BetterBasket class contains all the improved and tested code for the system.
 * 
 * @author  Your Name 
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable, Comparator<Product>
{
  private static final long serialVersionUID = 1L;
  

  
  @Override
  public boolean add(Product p1) {
	  //search existing products for matching record
	  for (Product p2: this) {
		  if (p1.getProductNum().equals(p2.getProductNum())) {
			  // found - update quantity and return
			  p2.setQuantity(p2.getQuantity()+p1.getQuantity());
			  return(true);
		  }
	  }
	  // not found - add new product, using superclass method
	  super.add(p1);
	  
	  Collections.sort(this, this);
	  return(true);
  }
  
  public int compare(Product p1, Product p2) {
	  return p1.getProductNum().compareTo(p2.getProductNum());
	    
  }
  
  
  
  public void sortProductsByPrice() {
	  Comparator<Product> priceComparator = Comparator.comparingDouble(Product::getPrice);
      Collections.sort(this, priceComparator);
  }
}
