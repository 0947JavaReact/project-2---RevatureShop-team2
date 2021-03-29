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
	@Column(name="email", unique=true)
	private String email;
	@Column(name="user_orders")
	private List<Order> orders;
	@Column(name="user_cart")
	private Cart currentCart;
	
	public User(String username, String password, String email, List<Order> orders, Cart currentCart) {
		super();
		Username = username;
		Password = password;
		this.email = email;
		this.orders = orders;
		this.currentCart = currentCart;
	}

	
}
