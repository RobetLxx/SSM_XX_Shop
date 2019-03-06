package com.shop.service.impl;

import com.shop.dao.CartDao;
import com.shop.entity.Cart;
import com.shop.service.CartService;
import com.shop.util.ShopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/18  下午9:51
 * @description: com.shop.CartDap
 */
@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao=null;

    public CartDao getCartDao() {
        return cartDao;
    }

    public void setCartDao(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public List<Cart> getCartsByUserId(String userId) {
        return cartDao.getCartsByUserId(userId);
    }

    @Override
    public Cart getCartBycartId(String id) {
        return cartDao.getCartBycartId(id);
    }

    @Override
    public Cart getCartById(String goodsid,String userid) {
        return cartDao.getCartById(goodsid,userid);
    }

    @Override
    public void updateCart(Cart cart) {
        cartDao.updateCart(cart);
    }

    @Override
    public void addCart(String userId, String goodsId, int num, float price) {
        Cart cart=new Cart();
        cart.setId(ShopUtil.getId());
        cart.setUserId(userId);
        cart.setGoodsId(goodsId);
        cart.setNum(num);
        cart.setPrice(price);
        cartDao.addCart(cart);
    }

    @Override
    public void updateCart_add(Cart cart) {
        cartDao.updateCart_add(cart);
    }

    @Override
    public void updateCart_re(Cart cart) {
        cartDao.updateCart_add(cart);
    }

    @Override
    public void deleteById(String id) {
        cartDao.deleteById(id);
    }

    @Override
    public Cart getCartByUserId(String userId) {
        return cartDao.getCartByUserId(userId);
    }
}
