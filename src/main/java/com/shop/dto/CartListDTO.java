package com.shop.dto;

import com.shop.entity.Cart;
import java.io.Serializable;
import java.util.List;

public class CartListDTO implements Serializable {
    private List<Cart> cartList;

    public CartListDTO() { super();}


    public List<Cart> getCartList() {
        return cartList;
    }
    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
