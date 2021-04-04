package com.revature.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "streetname")
	private String streetName;
	
	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "zipcode")
	private int zipcode;
	
	@OneToMany(mappedBy="creator",fetch=FetchType.LAZY)
	private List<Order> orders;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="cart_fk")
	private Cart currentCart;
	

	@Enumerated(EnumType.STRING)
	@Column(name = "user_type")
	private UserType userType;


	public User(String username, String password, String firstName, String lastName, String email, String streetName,
			String city, String state, int zipcode, List<Order> orders, Cart currentCart, UserType userType) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.orders = orders;
		this.currentCart = currentCart;
		this.userType = userType;
	}


	public User(int userId, String username, String password, String firstName, String lastName, String email,
			String streetName, String city, String state, int zipcode, List<Order> orders, Cart currentCart) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.orders = orders;
		this.currentCart = currentCart;
	}


	public User(String username, String password, String email, List<Order> orders, Cart currentCart) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.orders = orders;
		this.currentCart = currentCart;
	}
	
	
}