package com.shop.dao;

import com.shop.entity.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDao {
    /**
    * 增加一个OrderDetail对象
    * @param orderDetail 要增加的订单详细信息实体
    * @return
    */
    public void addOrderDetail(OrderDetail orderDetail);

    /**
    	 * 实现更新一个订单详细信息
    	 * @param orderDetail
    	 * @param
    	 */
    public void updateOrderDetail(OrderDetail orderDetail);

    /**
    * 通过Order的id来查询这个Order对应的所有的OrderDetail
    * @param orderId
    * @return
    */
    public List<OrderDetail> getOrderDetailByOrderId(String orderId);
}
