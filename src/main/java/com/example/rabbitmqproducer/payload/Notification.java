package com.example.rabbitmqproducer.payload;

import java.io.Serializable;

public class Notification implements Serializable {
    private String notificationType;
    private String msg;

    public Notification(){

    }

    public Notification(String notificationType, String msg) {
        this.notificationType = notificationType;
        this.msg = msg;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
