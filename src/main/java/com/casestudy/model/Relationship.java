package com.casestudy.model;

public class Relationship {
    private int id;
    private User receiptUser;
    private User sendUser;
    private int status;

    public Relationship() {
    }

    public Relationship(int id, User receiptUser, User sendUser, int status) {
        this.id = id;
        this.receiptUser = receiptUser;
        this.sendUser = sendUser;
        this.status = status;
    }

    public Relationship(User receiptUser, User sendUser, int status) {
        this.receiptUser = receiptUser;
        this.sendUser = sendUser;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getReceiptUser() {
        return receiptUser;
    }

    public void setReceiptUser(User receiptUser) {
        this.receiptUser = receiptUser;
    }

    public User getSendUser() {
        return sendUser;
    }

    public void setSendUser(User sendUser) {
        this.sendUser = sendUser;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "id=" + id +
                ", receiptUser=" + receiptUser +
                ", sendUser=" + sendUser +
                ", status=" + status +
                '}';
    }
}
