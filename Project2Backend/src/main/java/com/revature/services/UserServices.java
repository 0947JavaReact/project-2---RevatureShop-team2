package com.revature.services;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class UserServices {
	
	@Autowired
	private UserDao userDao;

	public User findByEmailAndPass(String email, String password) {
		 User user = userDao.findByEmailAndPassword(email, password);
		 return user;
	}

	public List<User> getAll() {
		return userDao.findAll();
	}

	public User getUserById(int id) {
		User user = userDao.findUserById(id);
		if (user == null) {
			return null;
		}
		return user;
	}

	public User insertUser(User user) {
		return userDao.save(user);
	}

	public void deleteUser(User user) {
		userDao.delete(user);
	}

}
