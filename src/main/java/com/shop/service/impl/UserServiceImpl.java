package com.shop.service.impl;

import com.shop.dao.UserDao;
import com.shop.entity.User;
import com.shop.service.UserService;
import com.shop.util.ShopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author: lingjunhao
 * create at:  19/2/16  下午7:35
 * @description:
 */

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao =null;



    @Override
    public void addLogin(User user) {
        user.setLoginId(ShopUtil.getId());
        user.setLoginTime(ShopUtil.getNow());
        userDao.addLogin(user.getLoginId(),user.getIp(),user.getName(),user.getLoginTime());
    }

    @Override
    public void updateEmail(String id, String email) {
        userDao.updateEmail(id,email);
    }

    @Override
    public void updatePhoneNum(String id, String phoneNum) {
        System.out.println("ServiceLmpl :"+phoneNum);
        userDao.updatePhoneNum(id,phoneNum);
    }

    @Override
    public void updatePassword(String id, String password) {
        userDao.updatePassword(id,password);
    }

    @Override
    public void register(User user) {
        user.setId(ShopUtil.getId());
        user.setRegTime(ShopUtil.getNow());
        user.setRole("u");
        user.setMoney(0);
        userDao.addUser(user);
    }

//    通过用户名和密码找到用户
    @Override
    public User findUser(String name, String password) {
        User user=this.userDao.getUserByNameAndPwd(name,password);
        return user;
    }

    @Override
    public boolean isexist(String name) {
        int num=userDao.getNumByName(name);
        return num !=0;
    }

    @Override
    public void updateUserImg(String id,String user_img) {
        userDao.updateUserImg(id,user_img);
    }


    @Override
    public void updateMoney(String id, float money) {
        userDao.updateMoney(id,money);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUser(String id) {
        return userDao.getUser(id);
    }

    @Override
    public void updateStatus(String id, int status) {
        userDao.updateStatus(id,status);
    }

    @Override
    public void updateMember(String memberId, Integer status, String memberId1, String password, String role) {
        userDao.updateStatus(memberId,status);
        userDao.updatePassword(memberId,password);
        userDao.updateRole(memberId,role);
    }
}
