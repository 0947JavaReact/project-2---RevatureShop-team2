package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.CartServices;
import com.revature.services.UserServices;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class CartController {

	private CartServices cartServ;
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getCartByUser(@RequestParam int userId){
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
}
