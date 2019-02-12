package com.example.demo.model.entity;

import java.util.Date;

public class GroupMember {
    private String id;

    private String alias;

    private String groupid;

    private String userid;

    private Integer notifylevel;

    private Integer permissiontype;

    private Date createat;

    private Date updateat;

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

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    public Date getUpdateat() {
        return updateat;
    }

    public void setUpdateat(Date updateat) {
        this.updateat = updateat;
    }
}