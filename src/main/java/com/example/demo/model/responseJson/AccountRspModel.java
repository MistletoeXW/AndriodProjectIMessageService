package com.example.demo.model.responseJson;

import lombok.Data;

/*
 * @program: IMessageServiice
 * @description: 用户信息封装
 * @author: xw
 * @create: 2019-02-18 11:47
 **/
@Data
public class AccountRspModel {

    private UserCard user;
    private String phone;
    private String token;
    private Boolean isBind;
}
