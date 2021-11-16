package com.casestudy.model;

public class    LikePost {
    private int id;
    private Post post;
    private User user;

    public LikePost() {
    }

    public LikePost(int id, Post post, User user) {
        this.id = id;
        this.post = post;
        this.user = user;
    }

    public LikePost(int id, Post post) {
        this.id = id;
        this.post = post;
    }

    public LikePost(Post post, User user) {
        this.post = post;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
