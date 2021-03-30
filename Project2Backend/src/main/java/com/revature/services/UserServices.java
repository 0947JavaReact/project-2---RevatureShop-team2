package com.revature.services;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.model.User;

public class UserServices {
	
	private UserDao userDao;

	public User getEmailPass(String email, String password) {
		User user = userDao.findByEmailAndPassword(email, password);
		if (user == null) {
			return null;
		}
		return user;
	}

	public List<User> getAll() {
		return userDao.findAll();

	}

	public User getUserById(int userId) {
		User user = userDao.findUserByUserId(userId);
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
