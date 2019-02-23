package com.example.demo.dao;

import com.example.demo.model.entity.User;
import com.example.demo.service.UserService;
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
    @Resource
    private UserService userService;

    @Test
    public void insert() {
        System.out.print(userService
                .juadeIsFollow("c286d6712ed411e982528c16454dcfe6"
                        ,"9299d0192f9c11e9a2d38c16454dcfe6"));

    }
}