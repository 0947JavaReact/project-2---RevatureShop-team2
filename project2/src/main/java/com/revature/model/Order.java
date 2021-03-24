package com.revature.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
	
	public static enum DeliveryStatus{
		PENDING, SHIPPED, DELIVERED, CANCELLED
	}
	private int orderNumber;
	private String creator;
	private double amount;
	private List<Item> items;
	private byte[] photo;
	private LocalDateTime orderTime;
	private LocalDateTime deliverTime;
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
	public LocalDateTime getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(LocalDateTime deliverTime) {
		this.deliverTime = deliverTime;
	}
	

	
	
	
	
	
	

}
