package com.example.demo.model.requestJson;

import lombok.Data;

/*
 * @program: IMessageServiice
 * @description: 用户注册提交的信息
 * @author: xw
 * @create: 2019-02-12 16:50
 **/
@Data
public class RegisterInfo {
    private String name;
    private String password;
    private String phone;
    private Integer sex;
    private String description;  //描述
    private String portrait; //头像
}
