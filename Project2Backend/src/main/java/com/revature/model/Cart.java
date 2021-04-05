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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name="Cart")
public class Cart {
	
	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Item> items;
	@Column(name="cart_total")
	private double amount;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "orders", "currentCart"})
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="creator_fk")
	private User cartCreator;
	
	public Cart(List<Item> items, double amount, User cartCreator) {
		super();
		this.items = items;
		this.amount = amount;
		this.cartCreator = cartCreator;
	}
	
}