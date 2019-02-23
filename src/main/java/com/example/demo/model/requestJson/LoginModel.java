package com.example.demo.model.requestJson;

import lombok.Data;

/*
 * @program: IMessageServiice
 * @description: 用户登录的请求
 * @author: xw
 * @create: 2019-02-12 22:55
 **/
@Data
public class LoginModel {
    private String phone;
    private String password;
    private String pushId;
}
