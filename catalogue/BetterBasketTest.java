package catalogue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BetterBasketTest {
	
	
	

	@Test
	void testMergeAddProduct() {
	    BetterBasket b = new BetterBasket();
	    Product p1 = new Product("0001", "Toaster", 10.00, 1);
	    Product p2 = new Product("0001", "Toaster", 10.00, 1);
	    Product p3 = new Product("0002", "Kettle", 15.00, 1);
	    Product p4 = new Product("0002", "Kettle", 15.00, 2);

	    b.add(p1);
	    b.add(p2);
	    assertEquals(1, b.size(), "Size incorrect after merge");
	    assertEquals(2, b.get(0).getQuantity(), "Quantity incorrect after merge");

	    b.add(p3);
	    assertEquals(2, b.size(), "Size incorrect after non-merge");

	    b.add(p4);
	    assertEquals(3, b.get(1).getQuantity(), "Quantity incorrect after reverse merge");
	}
	
	@Test
	void testAddProduct() {
	    BetterBasket b = new BetterBasket();
	    Product p1 = new Product("0001", "Toaster", 10.00, 1);
	    Product p2 = new Product("0002", "Microwave", 50.00, 1);
	    Product p3 = new Product("0003", "Kettle", 15.00, 1);

	    b.add(p3);
	    b.add(p1);
	    assertEquals("0001", b.get(0).getProductNum(), "Product missorted");
	    assertEquals("0003", b.get(1).getProductNum(), "Product missorted");

	    b.add(p2);
	    assertEquals("0002", b.get(0).getProductNum(), "Product incorrect after insert");
	    assertEquals("0001", b.get(1).getProductNum(), "Product incorrect after insert");
	    assertEquals("0003", b.get(2).getProductNum(), "Product incorrect after insert");
	}
	
	@Test
	void testSortByPrice() {
	    BetterBasket b = new BetterBasket();
	    Product p1 = new Product("0001", "Toaster", 10.00, 1);
	    Product p2 = new Product("0002", "Microwave", 50.00, 1);
	    Product p3 = new Product("0003", "Kettle", 15.00, 1);

	    b.add(p2);
	    b.add(p3);
	    b.add(p1);

	    b.sortProductsByPrice();

	    assertEquals("0002", b.get(0).getProductNum(), "Product incorrect after sort by price");
	    assertEquals("0003", b.get(1).getProductNum(), "Product incorrect after sort by price");
	    assertEquals("0001", b.get(2).getProductNum(), "Product incorrect after sort by price");
	}
	
	@Test
    public void testRemoveProduct() {
        BetterBasket b = new BetterBasket();

        
        Product p1 = new Product("0001", "Toaster", 10.00, 5);
	    Product p2 = new Product("0002", "Microwave", 50.00, 3);
	    Product p3 = new Product("0003", "Kettle", 15.00, 2);

        // Add products to the basket
        b.add(p1);
        b.add(p2);
        b.add(p3);

        // Test removing a product that exists in the basket
        assertTrue(b.removeProduct("P002"));
        assertEquals(2, b.size()); // Check if the size is updated

        // Test removing a product that doesn't exist in the basket
        assertFalse(b.removeProduct("P004"));
        assertEquals(2, b.size()); // Size should remain the same
    }
	
	
	
	
	
	
	
	
	
	
}
