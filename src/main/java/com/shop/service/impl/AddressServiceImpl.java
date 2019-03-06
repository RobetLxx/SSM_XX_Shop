package com.shop.service.impl;

import com.shop.dao.AddressDao;
import com.shop.entity.Address;
import com.shop.service.AddressService;
import com.shop.util.ShopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/18  下午9:24
 * @description: 地址service层接口
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao = null;

    @Override
    public void addAddress(Address address) {
        address.setId(ShopUtil.getId());
        if (address.getIsDefault()==null){
            //设置为一个约定的数，而不是默认值
            address.setIsDefault("2");
        }else {
            addressDao.setNotDefault(address.getUserId());
        }
        addressDao.addAddress(address);

    }

    @Override
    public void updateAddress(Address address) {
        Address oldaddress=addressDao.getAddressById(address.getId());
        oldaddress.setAccept(address.getAccept());
        oldaddress.setZip(address.getZip());
        oldaddress.setPhoneNum(address.getPhoneNum());
        oldaddress.setProvince(address.getProvince());
        oldaddress.setCity(address.getCity());
        oldaddress.setArea(address.getArea());
        oldaddress.setAddress(address.getAddress());
        if (address.getIsDefault()==null){
            oldaddress.setIsDefault("2");
        }else {
            addressDao.setNotDefault(address.getUserId());
        }
        addressDao.updateAddress(oldaddress);
    }

    @Override
    public List<Address> getAddress(String userId) {
        return addressDao.getAddress(userId);
    }

    @Override
    public Address getAddressById(String addressId) {
        return addressDao.getAddressById(addressId);
    }

    @Override
    public Address getAddressByIdAndUserId(String addressId, String userid) {
        return addressDao.getAddressByIdAndUserId(addressId,userid);
    }

    @Override
    public void setDefault(Address address) {
        //首先该用户的所有默认地址都设置为非默认
        //最终该用户的所有地址都是非默认
        addressDao.setNotDefault(address.getUserId());
        //在判断如果操作是设置默认，则将对应的地址信息设置为默认即可，若设置为取消默认，则已经取消了所有的默认了
        if (address.getIsDefault().equals("1"))
        {
            //设为默认
            addressDao.setNotDefault(address.getId());
        }
    }

    @Override
    public void deleteAddress(Address address) {
        addressDao.deleteAddress(address.getId());
    }

    @Override
    public void deleteAddress(String addressId) {
        addressDao.deleteAddress(addressId);
    }

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
}
