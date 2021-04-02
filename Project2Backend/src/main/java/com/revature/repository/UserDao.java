package com.revature.repository;

import java.util.List;

import com.revature.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
* UserDao/Repository interface!
*/ 
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	public List<User> findAll();

	public User findByEmailAndPassword(String email,String password);

	public User findUserById(int id);
	
	public User findUserByEmail(String email);

}