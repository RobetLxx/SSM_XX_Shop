package com.shop.service;

import com.shop.entity.Order;
import com.shop.entity.OrderDetail;
import com.shop.entity.PageBean;

import java.util.List;
import java.util.Map;

/**
* create by lingjunhao at 2019-02-19 12:33:14
* description: 订单服务层
*/

public interface OrderService {
    /**
    * 加一个Order
    * @param order 需要增加的订单信息
     * @param orderDetails 需要进行增加的订单详细的信息
    * @return
    */
    public void addOrder(Order order, List<OrderDetail> orderDetails);
    
    /**
    	 * 实现更新Order和OrderDetail
    	 * @param order 需要更新的订单信息 
    	 * @param orderDetails 需要更新的订单详细信息
    	 */
    public void updateOrder(Order order, List<OrderDetail> orderDetails);

    /**
     * 通过参数得到一个含有Order实体类的PageBean
     * @param page 当前的页数
     * @param order PageBean包含的实体类
     * @return
     */
    public PageBean<Order> getOrderByPage(int page, Order order);

    /**
    	 * 通过id的来获取订单信息
    	 * @param id 订单号
    	 */
    public Order getOrder(String id);
    
    /**
    * 通过用户的id来获取该用户的所有订单信息
    * @param userId
    * @return
    */
    public List<Order> getOrderByUserId(String userId);

    /**
     * 通过用户的id得到相关的订单信息
     * @param userId
     * @return 含有订单信息的Map<String, Object>
     */
    public Map<String, Object> getOrderInfoByUserId(String userId);

    /**
     * 通过Order的id来得到这个order所包含的所有的orderDetail
     * @param orderId
     * @return
     */
    public List<OrderDetail> getOrderDetailByOrderId(String orderId);

}
