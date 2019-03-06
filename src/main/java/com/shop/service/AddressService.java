package com.shop.service;

import com.shop.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/18  下午9:18
 * @description: 地址service层
 */
public interface AddressService {

    /**
    	 *添加新地址
    	 * @param  address
    	 */
    public void addAddress(Address address);


    public void updateAddress(Address address);
    /**
    	 * 通过用户的userId来获取当前用户的所有收货地址
    	 * @param userId 当前用户的userId
     * @return 返回地址的集合
    	 */
    public List<Address> getAddress(String userId);

    /**
    	 * 通过id的来获取当前id的地址信息
    	 * @param addressId 地址信息的Id
     * @return 当前id的地址信息
    	 */
    public Address getAddressById(String addressId);

    public Address getAddressByIdAndUserId(String addressId,String userid);

    /**
    * 设置当前地址为默认地址
    * @param address
    * @return
    */
    public void setDefault(Address address);

    /**
    	 * 删除地址信息
    	 * @param address 需要删除的地址实体类对象
    	 */
    public void deleteAddress(Address address);
    public void deleteAddress(String addressId);

}
