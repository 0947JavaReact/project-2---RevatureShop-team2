package com.revature.dao;
import com.revature.model.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderDao extends JpaRepository<Order, Integer>{
	public List<Order> findAll();
	public List<Order> findByCreator(int creator_id);
	public Order findById(int order_id);
}
