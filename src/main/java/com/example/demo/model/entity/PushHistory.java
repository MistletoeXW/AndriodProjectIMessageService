package com.example.demo.model.entity;

import java.util.Date;

public class PushHistory {
    private String id;

    private String receiverid;

    private String receiverpushid;

    private String senderid;

    private Integer entitytype;

    private Date arrivalat;

    private Date createat;

    private Date updateat;

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

    public byte[] getEntity() {
        return entity;
    }

    public void setEntity(byte[] entity) {
        this.entity = entity;
    }
}