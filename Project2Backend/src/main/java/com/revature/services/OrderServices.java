package com.revature.services;

import com.revature.repository.OrderDao;
import com.revature.model.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.revature.Project2BackendApplication;

@Service
@NoArgsConstructor
@AllArgsConstructor(onConstructor=@__(@Autowired))
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
		Project2BackendApplication.logger.info("order has been created by user: " + order.getCreator());
		orderDao.save(order);
	}

	public void deleteOrder(Order order) {
		Project2BackendApplication.logger.info("order" + order.getOrderNumber() + " has been deleted by user: " + order.getCreator());
		orderDao.delete(order);
	}

	public void updateOrder(Order order) {
		Project2BackendApplication.logger.info("order" + order.getOrderNumber() + " has been updated by user: " + order.getCreator());
		
	}
	

}
