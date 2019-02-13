package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.ConstCorrespond;
import com.example.demo.model.Result;
import com.example.demo.model.entity.User;
import com.example.demo.model.entity.UserExample;
import com.example.demo.model.requestJson.LoginInfo;
import com.example.demo.model.requestJson.RegisterInfo;
import com.example.demo.model.responseJson.UserCard;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.ResultTool;
import com.example.demo.utils.TextUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 * @program: IMessageServiice
 * @description: 用户相关的service业务
 * @author: xw
 * @create: 2019-02-12 16:46
 **/
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    //用户注册信息
    public Result register(RegisterInfo registerInfo){
        try{
            User user = new User();
            user.setName(registerInfo.getName());
            user.setPassword(TextUtil.getMD5(registerInfo.getPassword()));
            user.setPhone(registerInfo.getPhone());
            user.setSex(registerInfo.getSex());
            user.setDescription(registerInfo.getDescription());
            user.setPortrait(registerInfo.getPortrait());
            userMapper.insert(user);
            return ResultTool.success();
        }catch (Exception e){
            return ResultTool.error("注册失败！");
        }
    }

    //用户登录
    public Result login(LoginInfo loginInfo){
        try{
            if(loginInfo == null || loginInfo.getPhone()==null || loginInfo.getPassword() == null){
                return ResultTool.error("登录账号和密码不能为空!");
            }
            User user = userMapper.selectByPhone(loginInfo.getPhone());
            if(user == null){
                return ResultTool.error("您还没注册，请注册后再登录！");
            }
            else{
                String password = TextUtil.getMD5(loginInfo.getPassword());
                if(user.getPassword().equals(password)){
                    user.setToken(JwtUtil.createJwt(user.getId()));
                    UserCard userCard = new UserCard();
                    userCard.setId(user.getId());
                    userCard.setName(user.getName());
                    userCard.setPhone(user.getPhone());
                    userCard.setSex(ConstCorrespond.SEX_TPYE[user.getSex()]);
                    userCard.setDescription(user.getDescription());
                    userCard.setPortrait(user.getPortrait());
                    return ResultTool.success(userCard);
                }else{
                    return ResultTool.error("账号密码错误，请重新登录！");
                }
            }
        }catch (Exception e){
            return ResultTool.error("登录失败！");
        }
    }

}
