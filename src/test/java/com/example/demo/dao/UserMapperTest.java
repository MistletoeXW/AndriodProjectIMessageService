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
                .UserInfoById("c0ce68cc335511e980dd8c16454dcfe6"
                        ,"c286d6712ed411e982528c16454dcfe6"));

    }
}