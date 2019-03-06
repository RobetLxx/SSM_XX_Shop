package com.shop.dao;

import com.shop.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDao {
    /**
    * 增加一个order
    * @param order 需要增加的订单实体类
    * @return
    */
    public void addOrder(Order order);

    /**
    * 查询订单数量
    * @param order
    * @return 订单数量
    */
    public int getOrderNum(Order order);

    /**
    * 查询订单信息
    * @param id 订单号
    * @return 查询到的实体
    */
    public Order getOrder(String id);

    /**
    * 用于分页查询
    * @param params
    * @return
    */
    public List<Order> getOrderByPage(Map<String, Object> params);
    
    /**
    * 通过用户id来查询该用户的所有订单信息
    * @param userID
    * @return
    */
    public List<Order> getOrderByUserId(String userId);
    
    /**
    	 * 实现更新订单信息
    	 * @param order
    	 * @param  
    	 */
    public void updateOrder(Order order);
}
