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
@Table(name="Cart")
public class Cart {
	
	@Id
	@Column(name="cartNumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartNumber;
	
	@Column(name="creator", nullable=false)
	private String creator;
	
	@Column(name="cart_items")
	private List<Item> items;
	
	@Column(name="cart_total")
	private double amount;
	
	
}
