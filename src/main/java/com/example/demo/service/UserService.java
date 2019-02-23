package com.example.demo.service;

import com.example.demo.dao.UserFollowMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.ConstCorrespond;
import com.example.demo.model.Result;
import com.example.demo.model.entity.User;
import com.example.demo.model.entity.UserExample;
import com.example.demo.model.entity.UserFollow;
import com.example.demo.model.entity.UserFollowExample;
import com.example.demo.model.requestJson.LoginModel;
import com.example.demo.model.requestJson.RegisterModel;
import com.example.demo.model.requestJson.UserUpdateModel;
import com.example.demo.model.responseJson.AccountRspModel;
import com.example.demo.model.responseJson.UserCard;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.ResultTool;
import com.example.demo.utils.TextUtil;
import com.google.common.base.Strings;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    @Resource
    private UserFollowMapper userFollowMapper;

    //用户注册信息
    public Result register(RegisterModel registerModel){
        try{
            com.example.demo.model.entity.User user = new com.example.demo.model.entity.User();
            user.setName(registerModel.getName());
            user.setPassword(TextUtil.getMD5(registerModel.getPassword()));
            user.setPhone(registerModel.getPhone());
//            userCard.setSex(registerModel.getSex());
//            userCard.setDescription(registerModel.getDescription());
            userMapper.insert(user);
            return ResultTool.success(null);
        }catch (Exception e){
            return ResultTool.error("注册失败！");
        }
    }

    //用户登录
    public Result login(LoginModel loginModel){
        try{
            if(loginModel == null || loginModel.getPhone()==null || loginModel.getPassword() == null){
                return ResultTool.error("登录账号和密码不能为空!");
            }
            User user = userMapper.selectByPhone(loginModel.getPhone());
            if(user == null){
                return ResultTool.error("您还没注册，请注册后再登录！");
            }
            else{
                String password = TextUtil.getMD5(loginModel.getPassword());
                if(user.getPassword().equals(password)){
                    user.setPushid(loginModel.getPushId());
                    user.setToken(JwtUtil.createJwt(user.getId()));
                    userMapper.updateByPrimaryKey(user);
                    UserCard userCard = new UserCard();
                    userCard.setId(user.getId());
                    userCard.setName(user.getName());
                    userCard.setPhone(user.getPhone());
                    if(user.getSex() != null){
                        userCard.setSex(ConstCorrespond.SEX_TPYE[user.getSex()]);
                    }else {
                        userCard.setSex(null);
                    }
                    userCard.setDescription(user.getDescription());
                    userCard.setPortrait(user.getPortrait());
                    userCard.setToken(user.getToken());
                    AccountRspModel accountRspModel = new AccountRspModel();
                    accountRspModel.setUser(userCard);
                    accountRspModel.setPhone(user.getPhone());
                    accountRspModel.setToken(user.getToken());
                    if(user.getPushid() == null)
                        accountRspModel.setIsBind(false);
                    else
                        accountRspModel.setIsBind(true);
                    return ResultTool.success(accountRspModel);
                }else{
                    return ResultTool.error("账号密码错误，请重新登录！");
                }
            }
        }catch (Exception e){
            return ResultTool.error("登录失败！");
        }
    }

    /**
     * 给当前的账户绑定PushId
     *
     * @param userId   自己的UserId
     * @param pushId 自己设备的PushId
     * @return UserCard
     */
    public Result bindPushId(String userId, String pushId){
        try {
            if (Strings.isNullOrEmpty(pushId))
                return ResultTool.error("当前登录设备号获取失败");

            // 第一步，查询是否有其他账户绑定了这个设备
            // 取消绑定，避免推送混乱
            // 查询的列表不能包括自己
            UserExample example = new UserExample();
            example.createCriteria()
                    .andPushidEqualTo(pushId)
                    .andIdNotEqualTo(userId);
            List<User> userList = userMapper.selectByExample(example);
            if (userList.size() != 0) {
                for (User user : userList) {
                    user.setPushid(null);
                    userMapper.updateByPrimaryKey(user);
                }
            }
            //用户绑定pushId
            User user = userMapper.selectByPrimaryKey(userId);
            user.setPushid(pushId);
            userMapper.updateByPrimaryKey(user);
            return ResultTool.success();
        }catch (Exception e){
            return ResultTool.error("绑定失败！");
        }
    }

    //用户更新信息
    public Result updateUserInfo(String userId, UserUpdateModel userUpdateModel){
        try{
            User user = userMapper.selectByPrimaryKey(userId);
            user.setName(userUpdateModel.getName());
            user.setSex(userUpdateModel.getSex());
            user.setPortrait(userUpdateModel.getPortrait());
            user.setDescription(userUpdateModel.getDesc());
            userMapper.updateByPrimaryKey(user);
            return ResultTool.success();
        }catch (Exception e){
            return ResultTool.error("更新信息失败");
        }
    }

    //找到用户关注的人信息
    public Result contacts(String userId){
        try {
            UserFollowExample example = new UserFollowExample();
            example.createCriteria()
                    .andOriginidEqualTo(userId);
            List<UserFollow> userFollowList = userFollowMapper.selectByExample(example);
            List<UserCard> userCardFollowsCard = new ArrayList<>();
            if(userFollowList.size() == 0)
                return ResultTool.error("您当前没有关注的用户！");
            for (UserFollow userFollow : userFollowList) {
                UserCard userCard = new UserCard();
                User user = userMapper.selectByPrimaryKey(userFollow.getTargetid());
                userCard.setId(user.getId());
                userCard.setName(user.getName());
                userCard.setPhone(user.getPhone());
                userCard.setSex(ConstCorrespond.SEX_TPYE[user.getSex()]);
                userCard.setDescription(user.getDescription());
                userCard.setPortrait(user.getPortrait());
                userCard.setIsFollow(1);
                userCardFollowsCard.add(userCard);
            }
            return ResultTool.success(userCardFollowsCard);
        }catch (Exception e){
            return ResultTool.error("查询失败！");
        }
    }

    /**
     * 判断用户是否关注某用户
     */
    public int juadeIsFollow(String userId, String followId){
        UserFollowExample example = new UserFollowExample();
        example.createCriteria()
                .andOriginidEqualTo(userId)
                .andTargetidEqualTo(followId);
        List<UserFollow> userFollowList = userFollowMapper.selectByExample(example);
        if(userFollowList.size() != 0)
            return 1;//已经关注
        else
            return 0;//未关注
    }

    /**
     * 用户添加关注人
     */
    public Result Follows(String userId, String followId, String alias){
        try{
            //首先判断是否已经关注
            if(juadeIsFollow(userId,followId) != 0)
                return ResultTool.error("您已经关注过此用户！");
            //用户添加的同时添加的用户也要关注此用户，数据库中插入两条数据
            UserFollow userFollow = new UserFollow();
            userFollow.setOriginid(userId);
            userFollow.setTargetid(followId);
            userFollow.setAlias(alias);//添加备注
            UserFollow userFollow1 = new UserFollow();
            userFollow1.setOriginid(followId);
            userFollow1.setTargetid(userId);
            userFollowMapper.insert(userFollow);
            userFollowMapper.insert(userFollow1);
            return ResultTool.success();
        }catch (Exception e){
            return ResultTool.error("关注失败，请联系管理员！");
        }

    }

    /**
     * 根据userId获取用户信息
     */
    public Result UserInfoById(String id, String userId){
        try{
            com.example.demo.model.entity.User user = userMapper.selectByPrimaryKey(userId);
            if (user == null)
                return ResultTool.error("没有此用户！");
            UserCard userCard = new UserCard();
            userCard.setId(user.getId());
            userCard.setName(user.getName());
            userCard.setPhone(user.getPhone());
            userCard.setSex(ConstCorrespond.SEX_TPYE[user.getSex()]);
            userCard.setDescription(user.getDescription());
            userCard.setPortrait(user.getPortrait());
            if(juadeIsFollow(id,user.getId()) != 0)
                userCard.setIsFollow(1);
            else
                userCard.setIsFollow(0);
            return ResultTool.success(user);
        }catch (Exception e){
            return ResultTool.error("查询失败，服务器异常！");
        }
    }

    /**
     * 根据用户手机查询用户信息
     */
    public Result UserInfoByPhone(String userId,String phone){
        try{
            com.example.demo.model.entity.User user = userMapper.selectByPhone(phone);
            if (user == null)
                return ResultTool.error("没有此用户！");
            UserCard userCard = new UserCard();
            userCard.setId(user.getId());
            userCard.setName(user.getName());
            userCard.setPhone(user.getPhone());
            userCard.setSex(ConstCorrespond.SEX_TPYE[user.getSex()]);
            userCard.setDescription(user.getDescription());
            userCard.setPortrait(user.getPortrait());
            //判断是否已经关注
            if(juadeIsFollow(userId,user.getId()) != 0)
                userCard.setIsFollow(1);
            else
                userCard.setIsFollow(0);
            return ResultTool.success(userCard);
        }catch (Exception e){
            return ResultTool.error("查询失败，服务器异常！");
        }
    }

    /**
     * 根据name来搜索用户信息
     */
    public Result UserInfoByName(String id, String name){
        try{
            List<com.example.demo.model.entity.User> userList = userMapper.selectByName(name);
            if (userList == null)
                return ResultTool.error("没有此用户！");
            List<UserCard> userCardCardList = new ArrayList<>();
            for(com.example.demo.model.entity.User user : userList){
                UserCard userCard = new UserCard();
                userCard.setId(user.getId());
                userCard.setName(user.getName());
                userCard.setPhone(user.getPhone());
                userCard.setSex(ConstCorrespond.SEX_TPYE[user.getSex()]);
                userCard.setDescription(user.getDescription());
                userCard.setPortrait(user.getPortrait());
                //判读是否已经关注
                if(juadeIsFollow(id,user.getId()) != 0)
                    userCard.setIsFollow(1);
                else
                    userCard.setIsFollow(0);
                userCardCardList.add(userCard);
            }

            return ResultTool.success(userCardCardList);
        }catch (Exception e){
            return ResultTool.error("查询失败，服务器异常！");
        }
    }



}
