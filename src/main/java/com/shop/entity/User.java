package com.shop.entity;

import java.io.Serializable;

/**
 * @author: lingjunhao
 * create at:  19/2/16  下午5:24
 * @description: 用户表
 */
public class User implements Serializable {
    private String id;
    private String name;
    private String password;
    private String phoneNum;
    private float money;
    private String user_img;
    private String regTime;
    private String role;
    private int status;
    private String email;

    private String loginId;
    private String loginTime;
    private String ip;

    public User() {
        super();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", money=" + money +
                ", user_img='" + user_img + '\'' +
                ", regTime='" + regTime + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                ", email='" + email + '\'' +
                ", loginId='" + loginId + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
