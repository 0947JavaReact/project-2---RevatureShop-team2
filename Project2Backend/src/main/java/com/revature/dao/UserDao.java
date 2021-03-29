package com.revature.dao;

import java.util.List;

import com.revature.model.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Integer> {//needs the object its working with and the primary key
	//type as generics
	
	public List<User> findAll();
	public User findEmailPass(String email, String password);
    public User findUserById(int id);

}