package com.example.demo.model.entity;

import java.util.Date;

public class PushHistory {
    private String id;

    private String receiverid;

    private String receiverpushid;

    private String senderid;

    private Integer entitytype;

    private Date arrivalat;

    private Date createTime = new Date();

    private Date updateTime = new Date();

    private byte[] entity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(String receiverid) {
        this.receiverid = receiverid == null ? null : receiverid.trim();
    }

    public String getReceiverpushid() {
        return receiverpushid;
    }

    public void setReceiverpushid(String receiverpushid) {
        this.receiverpushid = receiverpushid == null ? null : receiverpushid.trim();
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid == null ? null : senderid.trim();
    }

    public Integer getEntitytype() {
        return entitytype;
    }

    public void setEntitytype(Integer entitytype) {
        this.entitytype = entitytype;
    }

    public Date getArrivalat() {
        return arrivalat;
    }

    public void setArrivalat(Date arrivalat) {
        this.arrivalat = arrivalat;
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

    public byte[] getEntity() {
        return entity;
    }

    public void setEntity(byte[] entity) {
        this.entity = entity;
    }
}