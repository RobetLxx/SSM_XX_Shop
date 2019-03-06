package com.shop.service;

import com.shop.entity.Cart;

import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/18  下午9:48
 * @description: 购物车service层
 */
public interface CartService {
    /**
    	 * 通过userId的来获取当前用户所有的购物车记录
    	 * @param userId
    	 */
    List<Cart> getCartsByUserId(String userId);

    public Cart getCartBycartId(String id);

    public Cart getCartById(String goodsid,String userid);

    public void updateCart(Cart cart);

    /**
    	 * 实现添加购物车记录
    	 * @param userId 
    	 * @param goodsId
        * @param num
     * @param price
     */
    public void addCart(String userId, String goodsId, int num, float price);

    public void updateCart_add(Cart cart);

    public void updateCart_re(Cart cart);

    /**
    	 * 通过id的来删除购物车
    	 * @param id
    	 */
    public void deleteById(String id);

    public Cart getCartByUserId(String userId);
}
