package com.revature.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	private int userId;
	@Column(name="username", unique=true, nullable=false)
	private String username;
	@Column(name="pass", nullable=false)
	private String password;
	@Column(name="email", unique=true)
	private String email;
	@OneToMany(mappedBy="creator", fetch=FetchType.LAZY)
	private List<Order> orders;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="cart_FK")
	private Cart userCart;
	
	public User(String username, String password, String email, List<Order> orders, Cart currentCart) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.orders = orders;
		this.userCart = currentCart;
	}

	
}
