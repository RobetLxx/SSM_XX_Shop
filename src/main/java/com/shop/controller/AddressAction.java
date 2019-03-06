package com.shop.controller;

import com.shop.entity.Address;
import com.shop.entity.User;
import com.shop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/19  下午3:44
 * @description: 地址Controller
 */
@Controller
@RequestMapping("/usercenter/address")
public class AddressAction {
    @Autowired
    private AddressService addressService;

    /**
    * 增加地址信息
    * @param session
     * @param address
    * @return
    */
    @RequestMapping("/add")
    public String add(HttpSession session, Address address){
        String userId=((User)session.getAttribute("user")).getId();
        address.setUserId(userId);
        addressService.addAddress(address);
        return "redirect:/usercenter/address/list";
    }


    /**
    * 修改地址信息
    * @param model
     * @param addressId
    * @return
    */
    @RequestMapping("/update")
    public String update(Model model, String addressId){
        Address address=addressService.getAddressById(addressId);
        model.addAttribute("address",address);
//        mv.addObject("addressId",addressId);
        return "/usercenter/address_update";
    }

    @RequestMapping("/updateinfo")
    public ModelAndView updateinfo(ModelAndView mv, Address address ){
        addressService.updateAddress(address);
        mv.setViewName("redirect:/usercenter/address/list");
        return mv;
    }


    /**
    * 显示所有已保存的地址信息
    * @param session
     * @param model
    * @return
    */
    @RequestMapping("/list")
    public String list(HttpSession session, Model model){
        String userId=((User)session.getAttribute("user")).getId();
        List<Address> addressList=addressService.getAddress(userId);
        model.addAttribute("addressList",addressList);
        return "/usercenter/address_list";
    }

    /**
    * 响应设置默认地址的方法
     * 默认地址值为 "1"
    * @param addressId
     * @param addressIsDefault
    * @return
    */
    @RequestMapping("/setDefault")
    public String setDefault(String addressId,String addressIsDefault){
        System.out.println(addressIsDefault.getClass());
        Address address = addressService.getAddressById(addressId);
        address.setIsDefault(addressIsDefault);
        addressService.setDefault(address);
        return "redirect:/usercenter/address/list";
    }

    /**
    * 响应删除地址的方法
    * @param addressId
    * @return
    */
    @RequestMapping("/delete")
    public String delete(String addressId){
        addressService.deleteAddress(addressId);
        return "redirect:/usercenter/address/list";
    }

}
