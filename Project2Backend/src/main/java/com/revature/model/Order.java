package com.revature.model;

import java.time.LocalDateTime;
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
@Table(name="orders")
public class Order {

	@Id
	@Column(name="order_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderNumber;

	@Column(name="creator", nullable=false)
	private String creator;

	@Column(name="total", nullable=false)
	private double amount;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "order_items",
		joinColumns = @JoinColumn(name = "order_number", referencedColumnName = "order_number"),
		inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "item_id"))
	private List<Item> items;

	@Column(name="order_photo")
	private byte[] photo;

	@Column(name="order_time")
	private LocalDateTime orderTime;

	@Column(name="deliver_time")
	private LocalDateTime deliverTime;
	

}
