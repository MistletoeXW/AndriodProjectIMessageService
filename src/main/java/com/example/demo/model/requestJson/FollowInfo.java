package com.example.demo.model.requestJson;

import lombok.Data;

/*
 * @program: IMessageServiice
 * @description: 用户添加关注人时填写的备注
 * @author: xw
 * @create: 2019-02-13 15:54
 **/
@Data
public class FollowInfo {
    private String alias;
    private String followId;
}
