package com.example.shoppingCartTest0929;

public class Item {

	private String itemName;
	private double price;
	private boolean sale;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean getSale() {
		return sale;
	}
	
	public void setSale(boolean sale) {
		this.sale = sale;
	}

	public Item(String itemName, double price, boolean sale) {
		this.itemName = itemName;
		this.price = price;
		this.sale = sale;
	}
}
