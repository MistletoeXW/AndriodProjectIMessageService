package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.model.requestJson.FollowInfo;
import com.example.demo.model.requestJson.LoginModel;
import com.example.demo.model.requestJson.RegisterModel;
import com.example.demo.model.requestJson.UserUpdateModel;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultTool;
import com.example.demo.utils.security.UserContext;
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
    public Result Register(@RequestBody RegisterModel registerModel){
        return userService.register(registerModel);
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result Login(@RequestBody LoginModel loginModel){
        return userService.login(loginModel);
    }

    @GetMapping("/Followings")
    @ApiOperation(value = "获取用户关注人的列表")
    public Result ContactList(){
        String userId = UserContext.getCurrentUser().getId();
        return userService.contacts(userId);
    }

    @PostMapping("/Follows")
    @ApiOperation(value = "用户添加关注人")
    public Result Follows(@RequestBody FollowInfo aliasInfo){
        String userId = UserContext.getCurrentUser().getId();
        if(userId.equalsIgnoreCase(aliasInfo.getFollowId()))
            return ResultTool.error("不能关注自己!");
        return userService.Follows(userId,aliasInfo.getFollowId(),aliasInfo.getAlias());
    }

    @PostMapping("/bind/{pushId}")
    @ApiOperation(value = "绑定设备Id")
    public Result bindPushId(@PathVariable("pushId") String pushId){
        String id = UserContext.getCurrentUser().getId();
        return userService.bindPushId(id,pushId);
    }

    @PostMapping("/updateUserInfo")
    @ApiOperation(value = "用户更新信息")
    public Result updateUserInfo(@RequestBody UserUpdateModel userUpdateModel){
        String id = UserContext.getCurrentUser().getId();
        return userService.updateUserInfo(id,userUpdateModel);
    }

    @GetMapping("/id/{userId}")
    @ApiOperation(value = "根据用户Id获取某人的信息")
    public Result UserInfoById(@PathVariable("userId") String userId){
        String id = UserContext.getCurrentUser().getId();
        return userService.UserInfoById(id,userId);
    }

    @GetMapping("/phone/{phone}")
    @ApiOperation(value = "根据用户手机号查询用户信息")
    public Result UserInfoByPhone(@PathVariable("phone") String phone){
        String userId = UserContext.getCurrentUser().getId();
        return userService.UserInfoByPhone(userId,phone);
    }

    @GetMapping("/name/{name}")
    @ApiOperation(value = "根据用户name获取某人的信息，采用模糊查询并升序排序")
    public Result UserInfoByName(@PathVariable("name") String name){
        String userId = UserContext.getCurrentUser().getId();
        return userService.UserInfoByName(userId,name);
    }



}
