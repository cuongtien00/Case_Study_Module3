package com.casestudy.model;

public class Post {
    private int id;
    private String tittle;
    private String content;
    private String image;
    private User user;

    public Post() {
    }

    public Post(int id, String tittle, String content, String image, User user) {
        this.id = id;
        this.tittle = tittle;
        this.content = content;
        this.image = image;
        this.user = user;
    }

    public Post(String tittle, String content, String image, User user) {
        this.tittle = tittle;
        this.content = content;
        this.image = image;
        this.user = user;
    }

    public Post(int id, String tittle, String content, String image) {
        this.id = id;
        this.tittle = tittle;
        this.content = content;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
