package com.revature.services;

import java.util.List;

import com.revature.model.Item;
import com.revature.repository.ItemDao;

public class ItemServices {

	private ItemDao iDao;

	public Item getItemByName(String name) {
		Item item = iDao.findByName(name);
		if (item == null) {
			return null;
		}
		return item;
	}

	public List<Item> getAllItems() {
		return iDao.findAll();
	}

	public void insertItem(Item item) {
		iDao.save(item);
	}

	public void deleteItem(Item item) {
		iDao.delete(item);
	}
}
