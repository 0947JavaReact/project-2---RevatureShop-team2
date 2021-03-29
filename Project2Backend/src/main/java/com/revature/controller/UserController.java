package com.revature.controller;

import java.util.List;

import com.revature.model.User;
import com.revature.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class UserController {

	@Autowired
	private UserServices userServices;
	
	// Get all Users
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userServices.getAll();
	}		
	
	// Create User rest api
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userServices.insertUser(user);
	}

    @GetMapping("/users/{emailId}")
	public ResponseEntity<User> getUserByLogin(@PathVariable String emailId, @PathVariable String password) {
        if( userServices.getEmailPass(emailId, password) == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>( userServices.getEmailPass(emailId, password),HttpStatus.OK);
	}
	
	
	// Get User by id rest api
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
        if( userServices.getUserById(id) == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>( userServices.getUserById(id),HttpStatus.OK);
	}
	
	
	// update employee rest api
	//TO-DO!
	//@PutMapping("/users/{id}")
	//public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
		
	//}


	
	// Delete User from api
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id")int id){
		User user =userServices.getUserById(id);
		userServices.deleteUser(user);
		return new ResponseEntity<>("Resource Deleted",HttpStatus.GONE);
	}
	
}
