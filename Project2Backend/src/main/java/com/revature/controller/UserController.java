package com.revature.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.services.UserServices;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class UserController {

	private UserServices userServices;
	
	// Get all Users
		@GetMapping("/users")
		public List<User> getAllUsers() {
			return this.userServices.getAll();
		}

		// Create User rest api
		@PostMapping("/register")
		public User createUser(@RequestBody LinkedHashMap<String, String> sMap, @RequestBody LinkedHashMap<String, String> oMap) {
			System.out.println();
			return this.userServices.insertUser(user);
		}

		@GetMapping("/user")
		public ResponseEntity<?> getUserByLogin(@RequestParam String emailId, @RequestParam String password) {
			User user = this.userServices.getEmailPass(emailId, password);
			if (user == null) {
				return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(user, HttpStatus.OK);
		}

		// Get User by id rest api
		@GetMapping("/users/{id}")
		public ResponseEntity<User> getUserById(@PathVariable int id) {
			if (this.userServices.getUserById(id) == null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(this.userServices.getUserById(id), HttpStatus.OK);
		}

		// Delete User from api
		@DeleteMapping("/users/{id}")
		public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
			User user = this.userServices.getUserById(id);
			this.userServices.deleteUser(user);
			return new ResponseEntity<>("Resource Deleted", HttpStatus.GONE);
		}
}
