package com.revature.model;

import java.util.Arrays;
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
@Table(name="items")
public class Item {
	
	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ItemId;
	
	@Column(name="item_name", nullable=false)
	private String name;
	
	@Column(name="price", nullable=false)
	private double price;
	
	@Column(name="item_photo")
	private byte[] photo;
	
	public Item(String name, double price, byte[] photo) {
		super();
		this.name = name;
		this.price = price;
		this.photo = photo;
		//this.itemtype = itemtype;
	}
}
