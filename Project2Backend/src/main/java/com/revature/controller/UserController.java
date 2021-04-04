package com.revature.controller;

import java.security.SecureRandom;
import java.util.List;

import com.revature.repository.UserDao;
import com.revature.model.User;
import com.revature.services.UserServices;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/*
* User Controller!
*/
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
@AllArgsConstructor(onConstructor=@__({@Autowired}))
@NoArgsConstructor
public class UserController {
	
	private UserServices userServices;
	private UserDao userDao;

	/*
	* Get all Users
	*/
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return this.userServices.getAll();
	}

	/*
	* Create the User 
	*/
	@PostMapping()
	public User createUser(@RequestBody User user) {
		System.out.println(user);
		return this.userServices.insertUser(user);
	}

	/*
	* Get the User by email and password to login
	*/
	@GetMapping("/user")
	public ResponseEntity<?> getUserByLogin(@RequestParam(name = "emailId") String emailId, @RequestParam(name = "password") String password) {
		User user = this.userServices.findByEmailAndPass(emailId, password);
		if (user == null) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	/*
	* Get the User by id
	*/
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		if (this.userServices.getUserById(id) == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(this.userServices.getUserById(id), HttpStatus.OK);
	}

	/*
	* Find the User by email
	*/
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

		int passwordLength = 5;
		String newPassword = generateRandomPassword(passwordLength);
        System.out.println(newPassword);

        String subject = "Revature Shop: Password";
        String body = "Your new password is " + newPassword +
					 ". You will be able to change your password in the Revature Shop app.";
		user.setPassword(newPassword);
        userServices.sendFromGMail(from, pass, to, subject, body);
		
	}

	/*
	*Update the User's Password
	*/
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User userPassword){
		User user = this.userServices.getUserById(id);
		user.setPassword(userPassword.getPassword());		
		User updatedUser = userDao.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	/*
	*Update the User's address
	*/
	@PutMapping("/address/{id}")
	public ResponseEntity<User> updateUserAddress(@PathVariable int id, @RequestBody User user){
		User currentUser = this.userServices.getUserById(id);
		currentUser.setStreetName(user.getStreetName());
		currentUser.setCity(user.getCity());
		currentUser.setState(user.getState());
		currentUser.setZipcode(user.getZipcode());
		User updatedUser = userDao.save(currentUser);
		return ResponseEntity.ok(updatedUser);
	}
	/*
	*Delete User from api
	*/
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
		User user = this.userServices.getUserById(id);
		this.userServices.deleteUser(user);
		return new ResponseEntity<>("Resource Deleted", HttpStatus.GONE);
	}

	 /*
	 * Generates Random Password
	 */
	 public static String generateRandomPassword(int len){
		 // ASCII range - alphanumeric (0-9, a-z, A-Z)
		 final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		 SecureRandom random = new SecureRandom();
		 StringBuilder sb = new StringBuilder();
		 // each iteration of loop choose a character randomly from the given ASCII range
		 // and append it to StringBuilder instance
		 for (int i = 0; i < len; i++) {
			 int randomIndex = random.nextInt(chars.length());
			 sb.append(chars.charAt(randomIndex));
		 }
		 return sb.toString();
	 }
	

}