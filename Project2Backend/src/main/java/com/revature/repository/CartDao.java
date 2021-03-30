package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Cart;
import com.revature.model.User;

public interface CartDao extends JpaRepository<Cart, Integer> {
	
	public Cart findByUser(User creator);

}
