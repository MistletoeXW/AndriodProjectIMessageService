package com.example.demo.service;

import com.example.demo.dao.GroupMapper;
import com.example.demo.dao.GroupMemberMapper;
import com.example.demo.dao.MessageMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.Result;
import com.example.demo.model.entity.Message;
import com.example.demo.model.entity.User;
import com.example.demo.model.requestJson.MessageCreateModel;
import com.example.demo.model.responseJson.MessageCard;
import com.example.demo.utils.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 * @program: IMessageServiice
 * @description: 消息发送的入口
 * @author: xw
 * @create: 2019-02-26 00:15
 **/
@Service
public class MessageService {
    @Resource
    private MessageMapper messageMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private PushHistoryService pushHistoryService;
    @Resource
    private GroupMapper groupMapper;
    @Resource
    private GroupMemberMapper groupMemberMapper;

    /*
    * // 发送一条消息到服务器
     */
    public Result pushMessage(String userId, MessageCreateModel model){

        if (!MessageCreateModel.check(model)) {
            return ResultTool.error();
        }

        User user = userMapper.selectByPrimaryKey(userId);

        //查询消息是否已经在数据库了
        Message message = messageMapper.selectByPrimaryKey(model.getId());

        if(message != null){
            return ResultTool.success(new MessageCard(message));
        }

//        if (model.getReceiverType() == Message.RECEIVER_TYPE_GROUP) {
//            return pushToGroup(user, model);
//        } else {
            return pushToUser(user, model);
//        }

    }

    // 发送到人
    private Result pushToUser(User sender, MessageCreateModel model) {
        User receiver = userMapper.selectByPrimaryKey(model.getReceiverId());
        if(receiver == null){
            //没有找到接收者
            return ResultTool.error("Con't find receiver user");
        }

        if (receiver.getId().equalsIgnoreCase(sender.getId())) {
            // 发送者接收者是同一个人就返回创建消息失败
            Result result = ResultTool.error();
            result.setCode(303);
            return result;
        }
        try{
            Message message = new Message();
            message.setId(model.getId());
            message.setSenderid(sender.getId());
            message.setReceiverid(model.getReceiverId());
            message.setAttach(model.getAttach());
            message.setContent(model.getContent());
            message.setType(model.getType());
            messageMapper.insert(message);
            return pushHistoryService.buildAndPushResponse(sender,message);
        }catch (Exception e){
            return ResultTool.error("插入数据库失败！");
        }

    }

    // 发送到群
//    private Result pushToGroup(User sender, MessageCreateModel model) {
//        //查询一个群，同时该用户必须为此群的成员
//
//    }

}
