package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserDao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class UserServices {
	
	private UserDao userDao;

	public User getEmailPass(String email, String password) {
		User user = this.userDao.findByEmailAndPassword(email, password);
		if (user == null) {
			return null;
		}
		return user;
	}

	public List<User> getAll() {
		return this.userDao.findAll();

	}

	public User getUserById(int userId) {
		User user = this.userDao.findUserByUserId(userId);
		if (user == null) {
			return null;
		}
		return user;
	}

	public User insertUser(User user) {
		return this.userDao.save(user);
	}

	public void deleteUser(User user) {
		this.userDao.delete(user);
	}

}
