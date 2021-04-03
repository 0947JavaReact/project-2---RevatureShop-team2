package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Cart;
import com.revature.model.User;
import com.revature.repository.CartDao;
import com.revature.repository.UserDao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class CartServices {

	private CartDao cartDao;
	
	public Cart findByCartCreator(User creator) {
		return cartDao.findByCartCreator(creator); 
	}
	
	public void insertCart(Cart cart) {
		cartDao.save(cart);
	}
	
	public Cart updateCart(Cart cart) {
		return cartDao.save(cart);
	}
}
