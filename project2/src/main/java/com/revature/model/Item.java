package com.revature.model;

import java.util.Arrays;
import java.util.List;

public class Item {
	
	private String name;
	private int ItemId;
	private double price;
	private byte[] photo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getItemId() {
		return ItemId;
	}
	public void setItemId(int itemId) {
		ItemId = itemId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	public Item(String name, int itemId, double price, byte[] photo) {
		super();
		this.name = name;
		ItemId = itemId;
		this.price = price;
		this.photo = photo;
	}
	
	public Item() {
		super();
	}
	
	@Override
	public String toString() {
		return "Item [name=" + name + ", ItemId=" + ItemId + ", price=" + price + ", photo=" + Arrays.toString(photo)
				+ "]";
	}
	
	
	
	
	
}
