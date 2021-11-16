package com.casestudy.model;

public class Relationship {
    private User user;
    private int status;

    public Relationship(User user, int status) {
        this.user = user;
        this.status = status;
    }

    public Relationship(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
