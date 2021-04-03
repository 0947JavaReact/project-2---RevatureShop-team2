package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Item;
import com.revature.repository.ItemDao;
import com.revature.repository.UserDao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class ItemServices {

private ItemDao iDao;
	
	public Item getItemByName(String name) {
		Item item = iDao.findByName(name);
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
	
	public void deleteItem(Item item) {
		
		iDao.delete(item);
	}
	
	public void updateItem(Item item) {
		iDao.save(item);
	}
}
