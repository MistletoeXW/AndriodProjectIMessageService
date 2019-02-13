package com.example.demo.dao;

import com.example.demo.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void insert() {
        System.out.print(userMapper.selectByName("user1"));

    }
}