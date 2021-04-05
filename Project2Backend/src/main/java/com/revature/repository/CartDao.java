package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Cart;
import com.revature.model.User;

public interface CartDao extends JpaRepository<Cart, Integer> {
	
	public Cart findByCartCreator(User creator);
	
	

}