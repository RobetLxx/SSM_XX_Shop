package com.shop.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: lingjunhao
 * create at:  19/2/19  上午11:54
 * @description: 订单实体类
 */
public class Order implements Serializable {
    private String id;
    private String userId;
    private Date orderTime;
    private String payType;
    private Date payTime;
    private Date sendTime;
    private Date completionTime;
    private String addressId;
    private float totalMoney;
    private String deliveryType;
    private String deliveryTime;
    private String status;

    private User user;
    private Address address;
    private OrderDetail orderDetail;

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", orderTime=" + orderTime +
                ", payType='" + payType + '\'' +
                ", payTime=" + payTime +
                ", sendTime=" + sendTime +
                ", completionTime=" + completionTime +
                ", addressId='" + addressId + '\'' +
                ", totalMoney=" + totalMoney +
                ", deliveryType='" + deliveryType + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", address=" + address +
                ", orderDetail=" + orderDetail +
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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Order() {
        super();
    }

}
