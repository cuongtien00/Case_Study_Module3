package com.casestudy.model;

public class User {
    private int id;
    private String fullName;
    private String introduction;
    private String userName;
    private String passWord;
    private Role role;

    public User() {
    }



    public User(int id, String fullName, String introduction, String userName, String passWord) {
        this.id = id;
        this.fullName = fullName;
        this.introduction = introduction;
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(int id, String fullName, String introduction, String userName, String passWord, Role role) {
        this.id = id;
        this.fullName = fullName;
        this.introduction = introduction;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }


    public User(String fullName, String introduction, String userName, String passWord, Role role) {
        this.fullName = fullName;
        this.introduction = introduction;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(String fullName, String introduction, String userName, String passWord) {
        this.fullName = fullName;
        this.introduction = introduction;
        this.userName = userName;
        this.passWord = passWord;




    }
}



