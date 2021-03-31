package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Item;
import com.revature.repository.ItemDao;

//import com.example.model.Food;
//import com.example.repository.FoodDao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@NoArgsConstructor
@AllArgsConstructor(onConstructor=@__(@Autowired))

public class ItemServices {
	
	private ItemDao iDao;
	
	public Item getItemByName(String name) {
		Item item = iDao.findByItemName(name);
		if(item==null) {
			return null;
		}
		return item;
	}
	
	public List<Item> getAllItems(){
		return iDao.findAll();
	}
	
	public void insertItem(Item item) {
		iDao.save(item);
	}
	
//	public List<Item> getItemByType(String type) {
//		return iDao.find
//	}
	
	public void deleteItem(Item item) {
		iDao.delete(item);
	}
}
