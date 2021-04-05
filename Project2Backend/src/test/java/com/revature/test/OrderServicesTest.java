package com.revature.test;

import com.revature.model.Cart;

import com.revature.model.Item;
import com.revature.model.Order;
import com.revature.model.User;
import com.revature.repository.OrderDao;
import com.revature.repository.UserDao;
import com.revature.services.ItemServices;
import com.revature.services.OrderServices;
import com.revature.services.UserServices;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServicesTest {
    @MockBean
    private OrderDao OrderRepo;

    @Autowired
    private OrderServices Oserv;


    @Test
    void getOrderById() {
        Order o1 = new Order(1,new User(),20,new LinkedList<Item>(),new byte[10],null,null);

        when(OrderRepo.findById(1)).thenReturn(o1);
        assertEquals(o1,Oserv.getOrderById(1));

    }

    @Test
    void getAllOrders() {
        Order o1 = new Order(1,new User(),20,new LinkedList<Item>(),new byte[10],null,null);
        Order o2 = new Order(2,new User(),20,new LinkedList<Item>(),new byte[10],null,null);

        when(OrderRepo.findAll()).thenReturn(Stream.of(o1,o2).collect(Collectors.toList()));

        assertEquals(2,Oserv.getAllOrders().size());
    }

    @Test
    void getAllCreatorOrders() {
        User u2 = new User(2,"testu2","password","Connor","Smith","fff@test.com","ffff","Clemon","SC",243333,new LinkedList<Order>(),new Cart());
        Order o1 = new Order(1,u2,20,new LinkedList<Item>(),new byte[10],null,null);

        when(OrderRepo.findByCreator(u2)).thenReturn(Stream.of(o1).collect(Collectors.toList()));

        assertEquals(1,Oserv.getAllCreatorOrders(u2).size());

    }


    @Test
    void insertOrder() {
        Order o2 = new Order(2,new User(),20,new LinkedList<Item>(),new byte[10],null,null);
        Oserv.insertOrder(o2);
        verify(OrderRepo,times(1)).save(o2);

    }

    @Test
    void deleteOrder() {
        Order o2 = new Order(2,new User(),20,new LinkedList<Item>(),new byte[10],null,null);
        Oserv.deleteOrder(o2);
        verify(OrderRepo,times(1)).delete(o2);
    }

    @Test
    void updateOrder() {
        Order o2 = new Order(2,new User(),20,new LinkedList<Item>(),new byte[10],null,null);
        Oserv.updateOrder(o2);
        verify(OrderRepo,times(1)).save(o2);
    }
}
