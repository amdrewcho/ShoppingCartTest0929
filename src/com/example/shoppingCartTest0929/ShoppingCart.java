package com.example.shoppingCartTest0929;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShoppingCart {

	private HashMap<Item, Integer> shoppingCart = new HashMap<>();

	public HashMap<Item, Integer> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(HashMap<Item, Integer> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public ShoppingCart() {
		this.shoppingCart = new HashMap<>();
	}

	public int cartSize() {
		return this.shoppingCart.size();
	}

	public double cartTotal() {
		double total = 0;
		Iterator mapIterator = this.shoppingCart.entrySet().iterator();
		while (mapIterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry)mapIterator.next();
			Item newItem = (Item)mapElement.getKey();
			total += newItem.getPrice() * (int)mapElement.getValue();
		}
		return total;
	}
	
	public String displayCart() {
		Iterator mapIterator = this.shoppingCart.entrySet().iterator();
		String cart = "";
		while (mapIterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry)mapIterator.next();
			Item newItem = (Item)mapElement.getKey();
			if (newItem.getSale() == true) {
				cart += "Item: " + newItem.getItemName() + ", Price: **$" + newItem.getPrice() + "**, Quantity: " + mapElement.getValue() + "\n"; 
			} else {
				cart += "Item: " + newItem.getItemName() + ", Price: $" + newItem.getPrice() + ", Quantity: " + mapElement.getValue() + "\n";
			}
		}
		return cart;
	}

	public void addItem(Item item) {
		if (this.shoppingCart.containsKey(item)) {
			this.shoppingCart.put(item, this.shoppingCart.get(item) + 1);
		} else {
			this.shoppingCart.put(item, 1);
		}
	}
	
	public void removeItem(Item item) {
		if (this.shoppingCart.containsKey(item) && this.shoppingCart.get(item) > 1) {
			this.shoppingCart.put(item, this.shoppingCart.get(item) - 1);
		} else {
			this.shoppingCart.remove(item);
		}
	}
	
	public void adjustQuantity(Item item, int quantity) {
		if (quantity == 0) {
			this.shoppingCart.remove(item);
		} else {
			this.shoppingCart.put(item, quantity);
		}
	}

}
