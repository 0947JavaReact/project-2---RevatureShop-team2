package com.revature.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Item;
import com.revature.services.ItemServices;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(value="/store")
@AllArgsConstructor(onConstructor=@__({@Autowired}))
@NoArgsConstructor

public class ItemController {
	private ItemServices iServ;
		
	@GetMapping("/{itemName}")
	public ResponseEntity<Item> getItemByName(@PathVariable("name")String name){
		if(iServ.getAllItems()==null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(iServ.getItemByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/allitems")
	public ResponseEntity<List<Item>> getAllItems(){
		if(iServ.getAllItems()==null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(iServ.getAllItems(),HttpStatus.OK);
	}
	
	
}