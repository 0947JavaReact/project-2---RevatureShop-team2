package com.revature.test;

import com.revature.model.Item;
import com.revature.repository.ItemDao;
import com.revature.repository.UserDao;
import com.revature.services.ItemServices;
import com.revature.services.UserServices;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
class ItemServicesTest {

    @MockBean
    private ItemDao testDao;

    @Autowired
    private ItemServices Iserv;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getItemByName() {
        Item i1 = new Item("testItem",5,new byte[10]);

        when(testDao.findItemByName("testItem")).thenReturn(i1);

        assertEquals(i1,Iserv.getItemByName("testItem"));
    }

    @Test
    void getAllItems() {
        Item i1 = new Item("testItem",5,new byte[10]);
        Item i2 = new Item("testItem2",5,new byte[10]);

        when(testDao.findAll()).thenReturn(Stream.of(i1,i2).collect(Collectors.toList()));

        assertEquals(2,Iserv.getAllItems().size());
    }

    @Test
    void insertItem() {
        Item i1 = new Item("testItem",5,new byte[10]);
        when(testDao.save(i1)).thenReturn(i1);
        assertEquals(i1,Iserv.insertItem(i1));
    }

    @Test
    void deleteItem() {
        Item i1 = new Item("testItem",5,new byte[10]);
        Iserv.deleteItem(i1);
        verify(testDao,times(1)).delete(i1);
    }

    @Test
    void updateItem() {
        Item i1 = new Item("testItem",5,new byte[10]);
        Iserv.deleteItem(i1);
        verify(testDao,times(1)).delete(i1);
    }
}
