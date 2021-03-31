package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	public List<User> findAll();
	public User findByEmailAndPassword(String email, String password);
    public User findUserByUserId(int userId);

}