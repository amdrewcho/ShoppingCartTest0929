package com.example.shoppingCartTest0929;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTestCase {

	ShoppingCart sc;

	@BeforeEach
	public void setUp() {
		sc = new ShoppingCart();
	}

	// Cart is empty at start
	@Test
	public void testIsEmpty() {
		assertEquals(0, sc.cartSize());
	}
	
	// Adding to empty cart makes sub-total = item price
	@Test
	public void addToEmptyCart() {
		Item apple = new Item("Apple", 0.99, false);
		sc.addItem(apple);
		assertEquals(apple.getPrice(), sc.cartTotal());
	}

	// Adding duplicate item updates quantity
	@Test
	public void addIsValid() {
		Item apple = new Item("Apple", 0.99, false);
		sc.addItem(apple);
		sc.addItem(apple);
		assertEquals(2, sc.getShoppingCart().get(apple));
	}

	// Removing duplicate item updates quantity
	@Test
	public void removeIsValid() {
		Item apple = new Item("Apple", 0.99, false);
		sc.addItem(apple);
		sc.addItem(apple);
		sc.addItem(apple);
		sc.removeItem(apple);
		assertEquals(2, sc.getShoppingCart().get(apple));
	}

	// Cart sub-total is properly calculated
	@Test
	public void priceIsValid() {
		Item apple = new Item("Apple", 0.99, false);
		Item orange = new Item("Orange", 1.50, false);
		Item banana = new Item("Banana", 2.00, false);
		sc.addItem(apple);
		sc.addItem(banana);
		sc.addItem(orange);
		assertEquals(4.49, sc.cartTotal());
	}

	// Cart properly displays non-sale and sale items
	@Test
	public void displayCartIsValid() {
		Item apple = new Item("Apple", 0.99, false);
		Item orange = new Item("Orange", 0.49, true);
		sc.addItem(apple);
		sc.addItem(orange);
		assertEquals("Item: Apple, Price: $0.99, Quantity: 1\nItem: Orange, Price: **$0.49**, Quantity: 1\n",
				sc.displayCart());
	}
	
	// Adjust quantity to non-zero value
	@Test
	public void adjustQuantityIsValid() {
		Item  apple = new Item("Apple", 0.99, false);
		sc.addItem(apple);
		sc.addItem(apple);
		sc.addItem(apple);
		sc.adjustQuantity(apple, 1);
		assertEquals(1, sc.getShoppingCart().get(apple));
	}
	
	// Adjusting quantity to zero updates cart display
	@Test
	public void adjustQuantityToZero() {
		Item apple = new Item("Apple", 0.99, false);
		Item orange = new Item("Orange", 0.49, true);
		sc.addItem(apple);
		sc.addItem(apple);
		sc.addItem(orange);
		sc.adjustQuantity(apple, 0);
		assertEquals("Item: Orange, Price: **$0.49**, Quantity: 1\n", sc.displayCart());
	}
}
