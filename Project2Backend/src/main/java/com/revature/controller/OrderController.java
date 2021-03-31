package com.revature.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Item;
import com.revature.model.Order;
import com.revature.model.User;
import com.revature.services.OrderServices;
import com.revature.services.UserServices;

public class OrderController {

	private OrderServices orderServ;
	private UserServices uServ;

	@PostMapping()
	public ResponseEntity<String> insertOrder(@RequestBody LinkedHashMap<String, String> fMap) {
		System.out.println(fMap);
		ObjectMapper mapper = new ObjectMapper();
		List<Item> oList = new ArrayList<Item>();
		try {
			 oList =  mapper.readValue(fMap.get("order_items"), new TypeReference<List<Item>>(){});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		User creator = uServ.getUserById((Integer)Integer.parseInt(fMap.get("creatorId")));
		String str = "2016-03-04 11:30";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	
		Order order = new Order(creator, Double.parseDouble(fMap.get("amount")), oList,
				fMap.get("order_photo").getBytes(),  LocalDateTime.parse(fMap.get("order_time"), formatter));

		orderServ.insertOrder(order);
		return new ResponseEntity<>("Resource was Created", HttpStatus.CREATED);
	}
	
	@GetMapping("/{orderNumber}")
	public ResponseEntity<Order> getOrderByOrderNumber(@PathVariable("orderNumber")String orderNumber){
		if(orderServ.getOrderById(Integer.parseInt(orderNumber)) == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(orderServ.getOrderById(Integer.parseInt(orderNumber)),HttpStatus.OK);
	}
	@GetMapping("/user/{creatorId}")
	public ResponseEntity<List<Order>> getOrderByCreator(@PathVariable("creatorId")String creator_id){
		if(orderServ.getAllCreatorOrders(Integer.parseInt(creator_id)) == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(orderServ.getAllCreatorOrders(Integer.parseInt(creator_id)),HttpStatus.OK);
	}
}
