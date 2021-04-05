package com.revature.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Cart;
import com.revature.model.Item;
import com.revature.model.User;
import com.revature.services.CartServices;
import com.revature.services.UserServices;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/cart")
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class CartController {

	private CartServices cartServ;
	private UserServices uServ;
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getCartByUser(@PathVariable("userId")String userId){
		return new ResponseEntity<>(cartServ.findByCartCreator(uServ.getUserById(Integer.parseInt(userId))), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Cart> addCartToUser(@RequestBody LinkedHashMap<String, Object> cMap) {
		int userId = (Integer) cMap.get("userId");
		User cUser = uServ.getUserById(userId);
		System.out.println(cUser.getUsername());
		Cart c = cartServ.findByCartCreator(cUser);
		if(c == null) {
			c = new Cart(new ArrayList<Item>(), 0, cUser);
			cartServ.insertCart(c);
			return new  ResponseEntity<>(c, HttpStatus.OK);
		}
		cartServ.insertCart(c);
		return new  ResponseEntity<>(c, HttpStatus.OK);
	}
	
}