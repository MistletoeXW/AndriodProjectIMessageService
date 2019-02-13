package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.model.requestJson.LoginInfo;
import com.example.demo.model.requestJson.RegisterInfo;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
 * @program: IMessageServiice
 * @description:
 * @author: xw
 * @create: 2019-02-12 21:48
 **/
@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public Result Register(@RequestBody RegisterInfo registerInfo){
        return userService.register(registerInfo);
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result Login(@RequestBody LoginInfo loginInfo){
        return userService.login(loginInfo);
    }

}
