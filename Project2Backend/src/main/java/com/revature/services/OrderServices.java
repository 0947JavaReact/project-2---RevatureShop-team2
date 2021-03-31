package com.revature.services;

import java.util.List;

import com.revature.model.Order;
import com.revature.repository.OrderDao;

public class OrderServices {

	private OrderDao orderDao;

	public Order getOrderById(int order_id) {
		Order order =  orderDao.findById(order_id);
		if(order==null) {
			return null;
		}
		return order;
	}

	public List<Order> getAllOrders() {
		return orderDao.findAll();
	}

	public List<Order> getAllCreatorOrders(int creator_id) {
		return orderDao.findByCreator(creator_id);
	}

	public void insertOrder(Order order) {
			orderDao.save(order);
	}

	public void deleteOrder(Order order) {
			orderDao.delete(order);
	}

	public void updateOrder(Order order) {
			orderDao.save(order);
	}
}
