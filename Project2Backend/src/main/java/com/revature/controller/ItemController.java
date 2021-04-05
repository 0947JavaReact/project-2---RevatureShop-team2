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
import org.springframework.web.multipart.MultipartFile;

import com.revature.model.Item;
import com.revature.services.ItemServices;
import com.revature.services.AmazonClient;
//import com.revature.imageretrieval.ImageRecovery;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/store")
//@CrossOrigin(origins="*")
//@AllArgsConstructor(onConstructor=@__({@Autowired}))
@NoArgsConstructor

public class ItemController {
	private ItemServices iServ;
	
	private AmazonClient amazonClient;
	
	@Autowired
	ItemController (ItemServices iServ, AmazonClient amazonClient){
		this.iServ = iServ;
		this.amazonClient = amazonClient;
	}
	
	
	//adding new item to the store
	//@PostMapping(value="/create", consumes=MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(value="/create")
	public @ResponseBody Item createItem(@RequestBody LinkedHashMap<String, Object> itemMap) {
	//public @ResponseEntity<String> insertItem(@RequestBody LinkedHashMap<String, Object> itemMap) {
		System.out.println(itemMap);
		//check if item name already exists
//		Item item = new Item((String) itemMap.get("name"), byte[] itemMap.get("item_photo")), Double.parseDouble((String) itemMap.get("price"))));
		Item item2 = new Item();
		item2.setName((String) itemMap.get("name"));
		//item2.setPhoto((byte[]) itemMap.get("photo"));
		
		if (itemMap.get("photo")==(null) || itemMap.get("photo").equals("null") || itemMap.get("photo").equals("")){
//			item2.setPhoto(null);
			item2.setPhoto(amazonClient.retrieveImage("image-coming-soon.png"));
		} else if (itemMap.get("photo").equals("default")) {
//			ImageRecovery ir = new ImageRecovery();
//			try {
//				//s3client
//				item2.setPhoto(ir.recoverImageFromUrl("https://p2revstoreimages.s3-us-west-1.amazonaws.com/image-coming-soon.png"));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			item2.setPhoto(amazonClient.retrieveImage("image-coming-soon.png"));
		} else {
			//item2.setPhoto(null);
			System.out.println(itemMap.get("photo"));
			String imageString = amazonClient.uploadFile((MultipartFile) itemMap.get("photo"));
			
			String parsedForACRetrieval = imageString.split("p2revstoreimages/")[1];
			
			System.out.println(parsedForACRetrieval);
			
			item2.setPhoto(amazonClient.retrieveImage(parsedForACRetrieval));
			//			ImageRecovery ir = new ImageRecovery();
//			try {
//				//ir.recoverImageFromUrl(imageString);
//				item2.setPhoto(ir.recoverImageFromUrl(imageString));
//				amazonClient.retrieveImage((String) itemMap.get("photo"));
//				//uploadFile returns String fileUrl... so just parse this to be everything after https://s3.us-west-1.amazonaws.com/p2revstoreimages/
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		//item2.setPhoto(null);
		item2.setPrice((Integer.parseInt((String) itemMap.get("price"))));
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
	
	//update item
//	@PutMapping("/item/{itemId}")
//	public ResponseEntity<Item> updateItem(@PathVariable )
	
	//delete item
	@DeleteMapping("/items/{itemName}")
	public ResponseEntity<String> deleteItem(@PathVariable("itemName") String itemName){
		Item item = this.iServ.getItemByName(itemName);
		this.iServ.deleteItem(item);
		return new ResponseEntity<>("Item Deleted", HttpStatus.GONE);
	}
	
}
