package com.example.demo.model.requestJson;

import lombok.Data;

/*
 * @program: IMessageServiice
 * @description: 用户更新信息提交的请求
 * @author: xw
 * @create: 2019-02-18 16:59
 **/
@Data
public class UserUpdateModel {
    private String name;
    private String portrait;
    private String desc;
    private int sex;
}
