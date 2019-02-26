package com.example.demo.service;

import com.example.demo.dao.PushHistoryMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.PushModel;
import com.example.demo.model.Result;
import com.example.demo.model.entity.Message;
import com.example.demo.model.entity.PushHistory;
import com.example.demo.model.entity.User;
import com.example.demo.model.responseJson.MessageCard;
import com.example.demo.utils.ResultTool;
import com.example.demo.utils.TextUtil;
import com.example.demo.utils.getui.PushDispatcher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 * @program: IMessageServiice
 * @description:
 * @author: xw
 * @create: 2019-02-26 16:24
 **/
@Service
public class PushHistoryService {

    @Resource
    private PushHistoryMapper pushHistoryMapper;
    @Resource
    private UserMapper userMapper;

    // 发送一条消息，并在当前的发送历史记录中存储记录
    private void pushNewMessage(User sender, Message message) {
        if (sender == null || message == null)
            return;

        // 消息卡片用于发送
        MessageCard card = new MessageCard(message);
        // 要推送的字符串
        String entity = TextUtil.toJson(card);

        // 发送者
        PushDispatcher dispatcher = new PushDispatcher();
        User receiver = userMapper.selectByPrimaryKey(message.getReceiverid());
        if (receiver == null)
            return;

        // 历史记录表字段建立
        PushHistory history = new PushHistory();
        // 普通消息类型
        history.setSenderid(sender.getId());
        history.setEntitytype(PushModel.ENTITY_TYPE_MESSAGE);
        history.setEntity(entity);
        history.setReceiverid(receiver.getId());
        // 接收者当前的设备推送Idi
        history.setReceiverpushid(receiver.getPushid());

        // 推送的真实Model
        PushModel pushModel = new PushModel();
        // 每一条历史记录都是独立的，可以单独的发送
        pushModel.add(history.getEntitytype(), history.getEntity());
        // 把需要发送的数据，丢给发送者进行发送
        dispatcher.add(receiver, pushModel);

        pushHistoryMapper.insert(history);

        //暂时省略群消息

        // 发送者进行真实的提交
        dispatcher.submit();

    }

    // 推送并构建一个返回信息
    public Result buildAndPushResponse(User sender, Message message) {
        if (message == null) {
            // 存储数据库失败
            return ResultTool.error("存储数据库失败");
        }

        // 进行推送
       pushNewMessage(sender, message);

        // 返回
        return  ResultTool.success(new MessageCard(message));
    }

}
