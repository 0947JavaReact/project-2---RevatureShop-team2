package com.revature.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name="Cart")
public class Cart {
	
	@Id
	@Column(name="cart_id")
	private int cartId;
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Item> items;
	@Column(name="cart_total")
	private double amount;
	
}
