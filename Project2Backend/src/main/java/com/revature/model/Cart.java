package com.revature.model;

import java.util.List;

import javax.persistence.*;

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

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "cart_items",
		joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "cart_id"),
		inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "item_id"))
	private List<Item> items;

	@Column(name="cart_total")
	private double amount;
	
}

