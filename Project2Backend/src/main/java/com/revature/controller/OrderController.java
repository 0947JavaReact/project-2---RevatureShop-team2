package com.revature.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Item;
import com.revature.model.Order;
import com.revature.model.User;
import com.revature.services.OrderServices;
import com.revature.services.UserServices;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(value = "/order")
@AllArgsConstructor(onConstructor=@__({@Autowired}))
@NoArgsConstructor
public class OrderController {
	private OrderServices orderServ;
	private UserServices uServ;
	
	@PostMapping()
	public ResponseEntity<String> insertOrder(@RequestBody LinkedHashMap<String, Object> fMap) {
		ArrayList<Object> fromFMap = (ArrayList<Object>) fMap.get("order_items");
		List<Item> itemList = new ArrayList<Item>();
		byte[] photo = null;
		
		for(int i=0; i < fromFMap.size();  i++) {
			LinkedHashMap<?,?> currItem = (LinkedHashMap<?, ?>) fromFMap.get(i);
			int itemID = Integer.parseInt((String) currItem.get("item_id"));
			Double itemPrice = Double.parseDouble((String) currItem.get("price"));
			String itemName =  (String) currItem.get("item_name");
			
			System.out.println(itemID);
			Item iTemp = new Item(itemID,itemName,itemPrice,photo);
			itemList.add(iTemp);
		}
		
		System.out.println(itemList);
		
		int userID = (Integer) fMap.get("creator");
		User cUser = uServ.getUserById(userID);
		double orderTotal = Double.parseDouble((String)fMap.get("total"));
	
		Order order = new Order(cUser,orderTotal, itemList,photo, LocalDateTime.now()  );
		
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
	@GetMapping("/user/{createrId}")
	public ResponseEntity<List<Order>> getOrderByCreator(@PathVariable("createrId")String creator_id){
		if(orderServ.getAllCreatorOrders(Integer.parseInt(creator_id)) == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(orderServ.getAllCreatorOrders(Integer.parseInt(creator_id)),HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Order>> getAllOrders(){
		if(orderServ.getAllOrders() == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(orderServ.getAllOrders(),HttpStatus.OK);
	}
	
}
