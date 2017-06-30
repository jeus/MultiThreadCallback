package com.jeus.multiThread.entity;

import java.util.Date;

public class SimpleMessage {

    final String type;
    final String id;
    final Date createDate;

    public SimpleMessage() {
        this.createDate = new Date();
        this.type = "TYP_"+createDate.getTime();
        this.id = "CID_"+createDate.getTime();
    }

    public SimpleMessage(String type, String id) {
        this.createDate = new Date();
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Date getCreateDate() {
        return createDate;
    }

}
