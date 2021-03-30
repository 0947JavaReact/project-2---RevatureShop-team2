package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="users")
public class User {
	
	public static enum UserType{
		CUSTOMER, DRIVER, MANAGER
	}
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int UserId;
	@Column(name="username", unique=true, nullable=false)
	private String Username;
	@Column(name="pass", nullable=false)
	private String Password;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@Column(name="email", unique=true)
	private String email;
	@Column(name="user_orders")
	private List<Order> orders;
	@Column(name="user_cart")
	private Cart currentCart;
	@Column(name="user_type")
	private int userType;
	
	public User(String username, String password, String firstname, String lastname, String email, List<Order> orders, Cart currentCart, int userType) {
		super();
		this.Username = username;
		this.firstname =firstname;
		this.lastname = lastname;
		this.Password = password;
		this.email = email;
		this.orders = orders;
		this.currentCart = currentCart;
		this.userType = userType;
	}

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

	public Cart getCurrentCart() {
		return currentCart;
	}

	public void setCurrentCart(Cart currentCart) {
		this.currentCart = currentCart;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [Password=" + Password + ", UserId=" + UserId + ", Username=" + Username + ", currentCart="
				+ currentCart + ", email=" + email + ", orders=" + orders + ", userType=" + userType + "]";
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
