package com.revature.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Item;
import com.revature.services.ItemServices;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/store")
//@AllArgsConstructor(onConstructor=@__({@Autowired}))
@NoArgsConstructor

public class ItemController {
	private ItemServices iServ;
	
	@Autowired
	ItemController (ItemServices iServ){
		this.iServ = iServ;
	}
	//adding new item to the store
	@PostMapping(value="/create")
	public @ResponseBody Item createItem(@RequestBody LinkedHashMap<String, Object> itemMap) {
		System.out.println(itemMap);
		
		Item item2 = new Item();
		item2.setName((String) itemMap.get("name"));
		//item2.setPhoto((byte[]) itemMap.get("photo"));
		item2.setPhoto(null);
		item2.setPrice((Integer) itemMap.get("price"));
		iServ.insertItem(item2);
		//return this.iServ.insertItem(item);
		System.out.println(item2);
		//return new ResponseEntity<>("Resource was Created", HttpStatus.CREATED);
		return item2;
	}
	
	
	//retrieve item by item name
	@GetMapping("/{itemName}")
	public ResponseEntity<Item> getItemByName(@PathVariable("itemName")String name){
		if(iServ.getAllItems()==null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(iServ.getItemByName(name),HttpStatus.OK);
	}
	
	//retrieve all items in the store
	@GetMapping("/allitems")
	public ResponseEntity<List<Item>> getAllItems(){
		
		if(iServ.getAllItems()==null) {
			System.out.println("in null items");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(iServ.getAllItems(),HttpStatus.OK);
	}
	
	//delete item
	@DeleteMapping("/items/{itemName}")
	public ResponseEntity<String> deleteItem(@PathVariable("itemName") String itemName){
		Item item = this.iServ.getItemByName(itemName);
		this.iServ.deleteItem(item);
		return new ResponseEntity<>("Item Deleted", HttpStatus.GONE);
	}
	
}
