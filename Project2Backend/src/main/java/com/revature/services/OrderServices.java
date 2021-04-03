package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Order;
import com.revature.model.User;
import com.revature.repository.OrderDao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
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

	public List<Order> getAllCreatorOrders(User creator) {
		return orderDao.findByCreator(creator);
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
