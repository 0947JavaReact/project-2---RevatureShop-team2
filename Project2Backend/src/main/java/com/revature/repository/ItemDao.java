package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Item;

public interface ItemDao extends JpaRepository<Item,Integer>{

	public List<Item> findAll();	
	public Item findByName(String name);
}
