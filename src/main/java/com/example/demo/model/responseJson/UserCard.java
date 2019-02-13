package com.example.demo.model.responseJson;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/*
 * @program: IMessageServiice
 * @description: 用户信息卡片
 * @author: xw
 * @create: 2019-02-12 17:07
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCard {
    private String id;

    private String name;

    private String phone;

    private String sex;

    private String description;

    private String portrait;

    private String token;

    private Date updateTime;//最后一次更新的时间

    private Integer following; //粉丝数

    private Integer follows;//用户关注的数量

    private Integer ifFollow;//当前用户是否已经关注了此用户
}
