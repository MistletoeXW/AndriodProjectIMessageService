package com.example.demo.dao;

import com.example.demo.model.entity.PushHistory;
import com.example.demo.model.entity.PushHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PushHistoryMapper {
    int countByExample(PushHistoryExample example);

    int deleteByExample(PushHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(PushHistory record);

    int insertSelective(PushHistory record);

    List<PushHistory> selectByExampleWithBLOBs(PushHistoryExample example);

    List<PushHistory> selectByExample(PushHistoryExample example);

    PushHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PushHistory record, @Param("example") PushHistoryExample example);

    int updateByExampleWithBLOBs(@Param("record") PushHistory record, @Param("example") PushHistoryExample example);

    int updateByExample(@Param("record") PushHistory record, @Param("example") PushHistoryExample example);

    int updateByPrimaryKeySelective(PushHistory record);

    int updateByPrimaryKeyWithBLOBs(PushHistory record);

    int updateByPrimaryKey(PushHistory record);
}