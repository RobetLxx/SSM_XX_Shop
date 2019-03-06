package com.shop.dao;

import com.shop.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/18  下午9:35
 * @description: 购物车Dao层
 */
public interface CartDao {
    /**
    	 * 实现添加购物车记录
    	 * @param cart
    	 * @param
    	 */
    public void addCart(Cart cart);

    public Cart getCartBycartId(@Param("id")String id);

    public Cart getCartById(@Param("goodsid")String goodsid, @Param("userid") String userid);

    public Cart getCartByUserId(String userId);

    /**
    	 * 通过id的来查询当前用户的所有购物车记录
    	 * @param userId
    	 */
    public List<Cart> getCartsByUserId(String userId);

    public void deleteById(String id);

	void updateCart_add(Cart cart);

	void updateCart_re(Cart oldCart);

	void updateCart(Cart cart);

}
