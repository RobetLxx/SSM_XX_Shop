package com.shop.entity;

import java.io.Serializable;

/**
 * @author: lingjunhao
 * create at:  19/2/18  下午3:08
 * @description: 访客
 */
public class Visit implements Serializable {
    private String id;
    private String ip;
    private String username;
    private String loginTime;

    public Visit(){
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }
}
