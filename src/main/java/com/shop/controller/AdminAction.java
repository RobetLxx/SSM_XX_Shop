package com.shop.controller;

import com.shop.entity.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/19  下午3:54
 * @description: 管理员Controller
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {
    @Autowired
    private UserService userService = null;
    
    /**
    * 查询用户权限列表
    * @param mv
    * @return 
    */
    @RequestMapping("/authorityList")
    public ModelAndView authorityList(ModelAndView mv){
        List<User> userList=userService.getAllUser();
        
        mv.addObject("userList",userList);
        mv.setViewName("/admin/authority_list");
        return mv;
    }
    
    /**
    * 向用户信息更新界面跳转
    * @param memberId
    * @param mv
     * @return 
    */
    @RequestMapping("/memberUpdate")
    public ModelAndView memberUpdate(String memberId,ModelAndView mv){
        User member = userService.getUser(memberId);
        mv.addObject("member",member);
        mv.setViewName("admin/member_update");
        return mv;
    }
    
    /**
    * 用户信息更新
    * @param status
     * @param memberId
     * @param password
     * @param role
     * @param mv
    * @return 
    */
    @RequestMapping("/memberUpdateOper")
    public ModelAndView memberUpdateOper(Integer status,String memberId,
                                         String password,String role,ModelAndView mv){
        System.out.println("password: "+password+",role: "+role+",status: "+status);
        userService.updateMember(memberId,status,memberId,password,role);
        mv.setViewName("admin/index");
        return mv;
    }
    
    /**
    * 向评论列表页面跳转
    * @param
    * @return
    */
    @RequestMapping("toCommentList")
    public String toCommentList(){
        return "admin/comment_list";
    }

    /**
    * 向评论详细信息页面跳转
    * @param
    * @return
    */
    @RequestMapping("toCommentView")
    public String toCommentView(){
        return "admin/comment_view";
    }

    /**
    * 向种类添加页面跳转
    * @param
    * @return
    */
    @RequestMapping("/toCategoryAdd")
    public String toCategoryAdd(){
        return "admin/category_add";
    }
    
    /**
    * 向admin主页跳转
    * @param
    * @return
    */
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "admin/index";
    }

    /**
    * 向订单查看页面跳转
    * @param
    * @return
    */
    @RequestMapping("/toOrderView")
    public String toOrderView(){
        return "admin/order_view";
    }

}
