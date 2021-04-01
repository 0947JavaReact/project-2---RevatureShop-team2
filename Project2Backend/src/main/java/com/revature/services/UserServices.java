
package com.revature.services;

import java.util.List;

import com.revature.repository.UserDao;
import com.revature.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__({@Autowired}))
@NoArgsConstructor
public class UserServices {

    private UserDao userDao;

    public User findByEmailAndPass(String email, String password) {
        User user = this.userDao.findByEmailAndPassword(email, password);
        return user;
    }

    public List<User> getAll() {
        return this.userDao.findAll();
    }

    public User getUserById(int id) {
        User user = this.userDao.findUserByUserId(id);
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
