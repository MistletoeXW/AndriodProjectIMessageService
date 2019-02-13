package com.example.demo.model.entity;


import java.util.Date;

public class UserFollow {
    private String id;

    private String alias;

    private String originid;

    private String targetid;

    private Date createTime = new Date();

    private Date updateTime = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getOriginid() {
        return originid;
    }

    public void setOriginid(String originid) {
        this.originid = originid == null ? null : originid.trim();
    }

    public String getTargetid() {
        return targetid;
    }

    public void setTargetid(String targetid) {
        this.targetid = targetid == null ? null : targetid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}