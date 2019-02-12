package com.example.demo.dao;

import com.example.demo.model.entity.UserFollow;
import com.example.demo.model.entity.UserFollowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFollowMapper {
    int countByExample(UserFollowExample example);

    int deleteByExample(UserFollowExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserFollow record);

    int insertSelective(UserFollow record);

    List<UserFollow> selectByExample(UserFollowExample example);

    UserFollow selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserFollow record, @Param("example") UserFollowExample example);

    int updateByExample(@Param("record") UserFollow record, @Param("example") UserFollowExample example);

    int updateByPrimaryKeySelective(UserFollow record);

    int updateByPrimaryKey(UserFollow record);
}