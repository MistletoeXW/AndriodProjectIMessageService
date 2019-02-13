package com.example.demo.model.entity;


import java.util.Date;

public class GroupMember {
    private String id;

    private String alias;

    private String groupid;

    private String userid;

    private Integer notifylevel;

    private Integer permissiontype;

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