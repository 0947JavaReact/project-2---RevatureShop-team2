package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Order;
import com.revature.model.User;

public interface OrderDao extends JpaRepository<Order, Integer> {

	public List<Order> findAll();
	public List<Order> findByCreator(User creator);
	public Order findById(int order_id);
}
