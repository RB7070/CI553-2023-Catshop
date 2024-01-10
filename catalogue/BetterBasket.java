package catalogue;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

/**
 * The BetterBasket class contains all the improved and tested code for the system.
 * 
 * @author Your Name
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable, Comparator<Product> {
    private static final long serialVersionUID = 1L;

    @Override
    public boolean add(Product p1) {
        // Search existing products for matching record
        for (Product p2 : this) {
            if (p1.getProductNum().equals(p2.getProductNum())) {
                
                p2.setQuantity(p2.getQuantity() + p1.getQuantity());
                return true;
            }
        }
        // Not found - add new product, using superclass method
        super.add(p1);

        // Sort the basket by product number
        sortProductsByPrice();
        return true;
    }

    @Override
    public int compare(Product p1, Product p2) {
        // Compare products by product number
        return p1.getProductNum().compareTo(p2.getProductNum());
    }

    // Sort products by product number
    public void sortProductsByProductNum() {
        Collections.sort(this, this);
    }

    // Sort products by price
    public void sortProductsByPrice() {
        Collections.sort(this, Comparator.comparingDouble(Product::getPrice).reversed());
    }
}