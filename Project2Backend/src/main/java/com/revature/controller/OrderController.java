package com.revature.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Cart;
import com.revature.model.Order;
import com.revature.model.User;
import com.revature.services.CartServices;
import com.revature.services.ItemServices;
import com.revature.services.OrderServices;
import com.revature.services.UserServices;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/order")
@AllArgsConstructor(onConstructor=@__({@Autowired}))
@NoArgsConstructor
public class OrderController {
	private OrderServices orderServ;
	private UserServices uServ;
	private CartServices cartServ;
	private ItemServices iServ;
	
	@PostMapping()
	public ResponseEntity<String> insertOrder(@RequestBody LinkedHashMap<String, Object> fMap) {
		byte[] photo = null;
		
		int userID = (Integer) fMap.get("creator");
		User cUser = uServ.getUserById(userID);
		Cart c = cartServ.findByCartCreator(cUser);
	
		Order order = new Order(cUser,c.getAmount(), new ArrayList<>(c.getItems()),photo, LocalDateTime.now()  );
		orderServ.insertOrder(order);
		c.setItems(new ArrayList<>());
		c.setAmount(0);
		cartServ.insertCart(c);
		return new ResponseEntity<>("Resource was Created", HttpStatus.CREATED);
	}
	
	@GetMapping("/{orderNumber}")
	public ResponseEntity<Order> getOrderByOrderNumber(@PathVariable("orderNumber")String orderNumber){
		if(orderServ.getOrderById(Integer.parseInt(orderNumber)) == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(orderServ.getOrderById(Integer.parseInt(orderNumber)),HttpStatus.OK);
	}
	@GetMapping("/user/{createrId}")
	public ResponseEntity<List<Order>> getOrderByCreator(@PathVariable("createrId")String creator_id){
		List<Order> currentOrders = orderServ.getAllCreatorOrders(uServ.getUserById(Integer.parseInt(creator_id)));
		if(currentOrders == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(currentOrders,HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Order>> getAllOrders(){
		if(orderServ.getAllOrders() == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(orderServ.getAllOrders(),HttpStatus.OK);
	}
	
	@PutMapping("/update/{order_id}")
	public ResponseEntity<Order> updateUser(@PathVariable int order_id,@RequestBody LinkedHashMap<String, Object> fMap){
		Order order = orderServ.getOrderById(order_id);
		order.setDeliverTime(LocalDateTime.now() );
		orderServ.insertOrder(order);
		return ResponseEntity.ok(order);
	}
	
}