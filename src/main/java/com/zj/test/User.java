package com.zj.test;

public class User {
    String userName;
    String userPass;

    public User(String userName,String userPass){
        this.userName = userName;
        this.userPass = userPass;
    }


    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userName+"-----"+userPass;
    }
}
