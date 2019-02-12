package com.example.demo.model.entity;

import java.time.LocalDateTime;

public class GroupMember {
    private String id;

    private String alias;

    private String groupid;

    private String userid;

    private Integer notifylevel;

    private Integer permissiontype;

    private LocalDateTime createTime = LocalDateTime.now();

    private LocalDateTime updateTime = LocalDateTime.now();

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

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getNotifylevel() {
        return notifylevel;
    }

    public void setNotifylevel(Integer notifylevel) {
        this.notifylevel = notifylevel;
    }

    public Integer getPermissiontype() {
        return permissiontype;
    }

    public void setPermissiontype(Integer permissiontype) {
        this.permissiontype = permissiontype;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}