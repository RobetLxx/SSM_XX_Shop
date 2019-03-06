package com.shop.dao;

import com.shop.entity.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/18  下午8:56
 * @description: 地址dao
 */
@Repository
public interface AddressDao {
    /**
    * 添加一个新地址
    * @param address 地址实体类对应的对象
    * @return
    */
    public void addAddress(Address address);

    public void updateAddress(Address address);
    /**
    * 得到当前登录用户的所有收货地址
    * @param userId 当前在线的用户id
    * @return 地址的集合
    */
    public List<Address> getAddress(String userId);

    /**
    * 将地址为id的地址信息设置为默认的地址信息
    * @param id 当前用户的id
    * @return
     *
    */
    public void setDefault(String id);

    /**
     * 将地址为id的地址信息设置为非默认的地址信息
     * @param userId 当前用户的userId
     * @return
     *
     */
    public void setNotDefault(String userId);
    
    /**
    * 删除地址信息
    * @param id 当前需要删除的地址id
    * @return
    */
    public void deleteAddress(String id);

    /**
    * 通过id来获取地址信息
    * @param addressId
    * @return
    */
    public Address getAddressById(String addressId);


    public Address getAddressByIdAndUserId(@Param("addressId") String addressId, @Param("userId") String userId);
}
