package com.revature.test;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.revature.repository.*;
import com.revature.services.*;
import com.revature.model.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServicesTest {

    @MockBean
    private UserDao UserRepo;

    @Autowired
    private UserServices Userv;

    @Test
    void findByEmailAndPass() {
        User u2 = new User(2,"testu2","password","Connor","Smith","fff@test.com","ffff","Clemon","SC",243333,new LinkedList<Order>(),new Cart());

        when(UserRepo.findByEmailAndPassword("fff@test.com","password")).thenReturn(u2);

        assertEquals(u2,Userv.findByEmailAndPass("fff@test.com","password"));
    }

    @Test
    void getAll() {
        List<User> returnList = new LinkedList<>();
        returnList.add(new User("testuser","password","testemail",new LinkedList<Order>(),new Cart()));

        when(UserRepo.findAll()).thenReturn(Stream.of(new User("testuser","password","testemail",new LinkedList<Order>(),new Cart())).collect(Collectors.toList()));

        assertEquals(1, Userv.getAll().size());
    }

    @Test
    void getUserById() {
        User u = new User(23,"testu2","password","Connor","Smith","fff@test.com","ffff","Clemon","SC",243333,new LinkedList<Order>(),new Cart());
        User u2 = new User(2,"testu2","password","Connor","Smith","fff@test.com","ffff","Clemon","SC",243333,new LinkedList<Order>(),new Cart());
        when(UserRepo.findUserByUserId(2)).thenReturn(u2);

        assertEquals(u2,Userv.getUserById(2));
    }

    @Test
    void getUserByEmail() {
        User u2 = new User(2,"testu2","password","Connor","Smith","fff@test.com","ffff","Clemon","SC",243333,new LinkedList<Order>(),new Cart());
        when(UserRepo.findUserByEmail("fff@test.com")).thenReturn(u2);

        assertEquals(u2,Userv.getUserByEmail("fff@test.com"));
    }

    @Test
    void insertUser() {
        User u2 = new User(2,"testu2","password","Connor","Smith","fff@test.com","ffff","Clemon","SC",243333,new LinkedList<Order>(),new Cart());
        when(UserRepo.save(u2)).thenReturn(u2);

        assertEquals(u2,Userv.insertUser(u2));

    }

    @Test
    void deleteUser() {
        User u2 = new User(2,"testu2","password","Connor","Smith","fff@test.com","ffff","Clemon","SC",243333,new LinkedList<Order>(),new Cart());
        Userv.deleteUser(u2);
        verify(UserRepo, times(1)).delete(u2);
    }
}
