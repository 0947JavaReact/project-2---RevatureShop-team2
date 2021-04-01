package com.revature.model;

import java.time.LocalDateTime;
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
import javax.persistence.ManyToOne;
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
@Table(name="orders")
public class Order {
	
	public static enum DeliveryStatus{
		PENDING, SHIPPED, DELIVERED, CANCELLED
	}
	@Id
	@Column(name="ordernumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderNumber;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "orders"})
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="creator_FK")
	private User creator;
	@Column(name="total", nullable=false)
	private double amount;
	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	private List<Item> items;
	@Column(name="order_photo")
	private byte[] photo;
	@Column(name="order_time")
	private LocalDateTime orderTime;
	@Column(name="deliver_time")
	private LocalDateTime deliverTime;
	
	public Order(User creator, double amount, List<Item> items, byte[] photo, LocalDateTime orderTime) {
		super();
		this.creator = creator;
		this.amount = amount;
		this.items = items;
		this.photo = photo;
		this.orderTime = orderTime;
	}
}
