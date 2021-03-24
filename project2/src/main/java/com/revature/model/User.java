package com.revature.model;

import java.util.List;

public class User {
	
	public static enum UserType{
		CUSTOMER, DRIVER, MANAGER
	}
	
	private int UserId;
	private String Username;
	private String Password;
	private String email;
	private List<Order> orders;
	private Cart currentCart;
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public Cart getCart() {
		return currentCart;
	}
	public void setCart(Cart cart) {
		this.currentCart = cart;
	}
	
	public User(String username, String password, String email, List<Order> orders, Cart cart) {
		super();
		Username = username;
		Password = password;
		this.email = email;
		this.orders = orders;
		this.currentCart = cart;
	}
	
	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return "Item [UserId=" + UserId + ", Username=" + Username + ", Password=" + Password + ", email=" + email
				+ ", orders=" + orders + ", cart=" + currentCart + "]";
	}

}
