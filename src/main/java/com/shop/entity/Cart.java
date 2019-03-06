package com.shop.entity;

import java.io.Serializable;

/**
 * @author: lingjunhao
 * create at:  19/2/18  下午9:33
 * @description: 购物车实体类
 */
public class Cart implements Serializable {
    private String id;
    private String userId;
    private String goodsId;
    private int num;
    private float price;
    private Goods goods;

    public Cart() {
        super();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", goods=" + goods +
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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
