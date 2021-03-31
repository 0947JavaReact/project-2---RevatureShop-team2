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

	public Order() {
	}

	public Order(int orderNumber, String creator, double amount, List<Item> items, byte[] photo,
			LocalDateTime orderTime, LocalDateTime deliverTime) {
		this.orderNumber = orderNumber;
		this.creator = creator;
		this.amount = amount;
		this.items = items;
		this.photo = photo;
		this.orderTime = orderTime;
		this.deliverTime = deliverTime;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public LocalDateTime getDeliverTime() {
		return deliverTime;
	}

	public void setDeliverTime(LocalDateTime deliverTime) {
		this.deliverTime = deliverTime;
	}
	

}
