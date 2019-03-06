package com.shop.entity;

import java.io.Serializable;

/**
 * @author: lingjunhao
 * create at:  19/2/19  上午11:58
 * @description: 订单详细实体类
 */
public class OrderDetail implements Serializable {
    private String id;
    private String orderId;
    private String goodsId;
    private int nums;
    private int payStatus;
    private int sendStatus;
    private int orderStatus;
    private float dealPrice;

    private Goods goods;

    public OrderDetail() {
        super();
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", nums=" + nums +
                ", payStatus=" + payStatus +
                ", sendStatus=" + sendStatus +
                ", orderStatus=" + orderStatus +
                ", dealPrice=" + dealPrice +
                ", goods=" + goods +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public int getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(int sendStatus) {
        this.sendStatus = sendStatus;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public float getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(float dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
