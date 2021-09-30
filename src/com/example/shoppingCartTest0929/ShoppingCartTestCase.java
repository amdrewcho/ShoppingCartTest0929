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
	@Test
	public void testIsEmpty() {
		assertEquals(0, sc.cartSize());
	}
	@Test 
	public void updateIsValid() {
		Item apple = new Item("Apple", 0.99);
		sc.addItem(apple);
		sc.addItem(apple);
		assertEquals(2, sc.getShoppingCart().get(apple));
	}
	@Test
	public void priceIsValid() {
		Item apple = new Item("Apple", 0.99);
		Item orange = new Item("Orange", 1.50);
		Item banana = new Item("Banana", 2.00);
		sc.addItem(apple);
		sc.addItem(banana);
		sc.addItem(orange);
		assertEquals(4.49, sc.cartTotal());
	}
}
