package com.revature.model;

import java.time.LocalDateTime;
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
@Table(name="orders")
public class Order {
	
	public static enum DeliveryStatus{
		PENDING, SHIPPED, DELIVERED, CANCELLED
	}
	@Id
	@Column(name="ordernumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderNumber;
	@Column(name="creator", nullable=false)
	private String creator;
	@Column(name="total", nullable=false)
	private double amount;
	@Column(name="order_items", nullable=false)
	private List<Item> items;
	@Column(name="order_photo")
	private byte[] photo;
	@Column(name="order_time")
	private LocalDateTime orderTime;
	@Column(name="deliver_time")
	private LocalDateTime deliverTime;
	

}
