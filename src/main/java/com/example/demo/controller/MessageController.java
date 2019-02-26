package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.model.requestJson.MessageCreateModel;
import com.example.demo.service.MessageService;
import com.example.demo.utils.security.UserContext;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
 * @program: IMessageServiice
 * @description:
 * @author: xw
 * @create: 2019-02-26 15:13
 **/
@RestController
@CrossOrigin
public class MessageController {

    @Resource
    private MessageService messageService;

    @PostMapping(value = "/msg")
    @ApiOperation(value = "用户发送消息")
    public Result pushMessage(@RequestBody MessageCreateModel messageCreateModel){
        String userId = UserContext.getCurrentUser().getId();
        return messageService.pushMessage(userId,messageCreateModel);
    }


}
