package com.shop.entity;

import java.io.Serializable;

/**
 * @author: lingjunhao
 * create at:  19/2/18  下午8:48
 * @description: 地址实体类
 */
public class Address implements Serializable {
    private String id;
    private String userId;
    private String accept;
    private String zip;
    private String phoneNum;
    private String province;
    private String city;
    private String area;
    private String address;
    private String isDefault;


    public Address() {
        super();
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", userid='" + userId + '\'' +
                ", accept='" + accept + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", isdefault='" + isDefault + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userid) {
        this.userId = userid;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }


}
