package com.shop.dto;

import com.shop.entity.OrderDetail;
import java.io.Serializable;
import java.util.List;

public class OrderDetailListDTO implements Serializable {
    List<OrderDetail> orderDetailList;

    public OrderDetailListDTO() {
        super();
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
