package com.shop.controller;

import com.shop.entity.Cart;
import com.shop.entity.User;
import com.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/19  下午3:37
 * @description: 购物车controller
 */
@Controller
@RequestMapping("/cart")
public class CartAction {
    @Autowired
    CartService cartService=null;
    /**
    	 * 通过cartID的来删除购物车记录
    	 * @param cartId
     * @param mv
     * @param session
     * @return
    	 */
    @RequestMapping("/deleteById")
    public ModelAndView deleteById(String cartId, ModelAndView mv, HttpSession session){
        cartService.deleteById(cartId);
        mv.setViewName("redirect:/cart/listByUser");
        return mv;
    }

    /**
    * 修改购物车信息
    * @param mv
     * @param id
    * @return
    */
    @RequestMapping("/numadd")
    public ModelAndView update_add(ModelAndView mv,String id,HttpSession session){
        Cart cart=cartService.getCartBycartId(id);
        cart.setNum(cart.getNum()+1);
        cartService.updateCart_add(cart);
        mv.setViewName("redirect:/cart/listByUser");
        return mv;
    }

    @RequestMapping("/numre")
    public ModelAndView update_re(ModelAndView mv,String id,HttpSession session){
        Cart cart=cartService.getCartBycartId(id);
        cart.setNum(cart.getNum()-1);
        cartService.updateCart_re(cart);
        mv.setViewName("redirect:/cart/listByUser");
        return mv;
    }


    /**
    * 以用户为单位查询购物车记录
    * @param session
     * @param mv
    * @return
    */
    @RequestMapping("/listByUser")
    public ModelAndView list(HttpSession session,ModelAndView mv){
        String userId=((User)session.getAttribute("user")).getId();
        List<Cart> cartList=cartService.getCartsByUserId(userId);
        mv.addObject("cartList",cartList);
        mv.setViewName("cart");
        return mv;
    }

    //需要对添加入购物车的信息进行检查，若商品在购物车中已有，则只需要增加num和price即可
    @RequestMapping("/addcheck")
    public ModelAndView addcheck(HttpSession session,String goodsId,Integer num,Float price,ModelAndView mv){
        System.out.println(goodsId);
        System.out.println(num);
        System.out.println(price);
        String userid=((User)session.getAttribute("user")).getId();
        Cart cart = cartService.getCartById(goodsId,userid);
        if (cart==null){
            session.setAttribute("goodsId",goodsId);
            session.setAttribute("num",num);
            session.setAttribute("price",price);
            session.setAttribute("userid",userid);
            mv.setViewName("redirect:/cart/add");
        }
        else {
            cart.setNum(num+cart.getNum());
            cart.setPrice(price);
            cartService.updateCart(cart);
            mv.setViewName("redirect:/cart/listByUser");
        }


        return mv;
    }

    /**
    * 增加购物车记录
    * @param session
     * @param mv
    * @return 返回购物车列表展示界面
    */
    @RequestMapping("/add")
    public ModelAndView addCart(HttpSession session,ModelAndView mv){
        String goodsId=(String)session.getAttribute("goodsId");
        Integer num = (Integer)session.getAttribute("num");
        Float price = (Float)session.getAttribute("price");
        String userid=(String)session.getAttribute("userid");
        cartService.addCart(userid,goodsId,num,price);
        //进入之后的下单页面order/add需要goodsId和Num
        mv.addObject("goodsId",goodsId);
        mv.addObject("num",num);
        mv.setViewName("redirect:/cart/listByUser");
        return mv;
    }

}
