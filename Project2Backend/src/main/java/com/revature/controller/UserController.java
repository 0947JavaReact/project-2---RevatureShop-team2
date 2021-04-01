package com.revature.controller;

import java.util.List;

import com.revature.model.User;
import com.revature.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServices userServices;

	// Get all Users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return this.userServices.getAll();
	}

	// Create User rest api
	@PostMapping()
	public User createUser(@RequestBody User user) {
		return this.userServices.insertUser(user);
	}

	@GetMapping("/user")
	public ResponseEntity<?> getUserByLogin(@RequestParam String emailId, @RequestParam String password) {
		User user = this.userServices.findByEmailAndPass(emailId, password);
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

	// Get User by email rest api
	@GetMapping("/reset/{email}")
	public void findUserByEmail(@PathVariable String email) {
		User user = this.userServices.getUserByEmail(email);
		if (user == null) {
			 System.out.println("User is null");
		}
		//Replace it with your gmail creds.
		String from = "revatureshop"; // GMail user name (just the part before "@gmail.com")
        String pass = "p4ssword123"; // GMail password

		String[] to = { user.getEmail() };
         // list of recipient email addresses
        String subject = "Reset Password";
        String body = "Contact the HR department to reset password for now!";
        userServices.sendFromGMail(from, pass, to, subject, body);
		
	}

	// Delete User from api
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
		User user = this.userServices.getUserById(id);
		this.userServices.deleteUser(user);
		return new ResponseEntity<>("Resource Deleted", HttpStatus.GONE);
	}
	

}