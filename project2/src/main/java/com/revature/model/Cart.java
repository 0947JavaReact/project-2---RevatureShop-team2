package com.revature.model;

import java.util.List;

public class Cart {
	
	private List<Item> items;
	private double amount;
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Cart(List<Item> items, double amount) {
		super();
		this.items = items;
		this.amount = amount;
	}
	public Cart() {
		super();
	}
	
	@Override
	public String toString() {
		return "Cart [items=" + items + ", amount=" + amount + "]";
	}
	
}
