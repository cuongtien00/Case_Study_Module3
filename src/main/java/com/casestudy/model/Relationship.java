package com.casestudy.model;

public class Relationship {
    private User user2;
    private User user1;
    private int status;

    public Relationship() {
    }

    public Relationship(User user2, User user1, int status) {
        this.user2 = user2;
        this.user1 = user1;
        this.status = status;
    }

    public Relationship(int status) {
        this.status = status;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
