package com.example.demo.dao;

import com.example.demo.model.entity.GroupMember;
import com.example.demo.model.entity.GroupMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupMemberMapper {
    int countByExample(GroupMemberExample example);

    int deleteByExample(GroupMemberExample example);

    int deleteByPrimaryKey(String id);

    int insert(GroupMember record);

    int insertSelective(GroupMember record);

    List<GroupMember> selectByExample(GroupMemberExample example);

    GroupMember selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GroupMember record, @Param("example") GroupMemberExample example);

    int updateByExample(@Param("record") GroupMember record, @Param("example") GroupMemberExample example);

    int updateByPrimaryKeySelective(GroupMember record);

    int updateByPrimaryKey(GroupMember record);
}