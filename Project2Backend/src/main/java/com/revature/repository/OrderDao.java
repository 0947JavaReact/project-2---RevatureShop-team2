package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {

	public List<Order> findAll();
	public List<Order> findByCreator(int creator_id);
	public Order findById(int order_id);
}
