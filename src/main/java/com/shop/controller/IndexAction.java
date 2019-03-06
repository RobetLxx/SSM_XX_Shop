package com.shop.controller;

import com.shop.entity.Category;
import com.shop.entity.Goods;
import com.shop.service.CategoryService;
import com.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/19  下午2:10
 * @description: 主页action
 */
@Controller
public class IndexAction {
    @Autowired
    public CategoryService categoryService;
    @Autowired
    public GoodsService goodsService;


    /**
    * @param model
    * @param session
    * @return
    */
    @RequestMapping("/index")
    public String execute(Model model, HttpSession session){
        int Max=8;
        List <Goods> hotGoodses = goodsService.getGoodsByRole(Max);
        List<Goods> goodsesLasted = goodsService.getGoodsBySellTime(Max);
        List<Category> categories = categoryService.getCateoriesForIndex();
        model.addAttribute("hotGoodses",hotGoodses);
        model.addAttribute("goodsesLasted",goodsesLasted);
        model.addAttribute("categories",categories);

        session.setAttribute("base",session.getServletContext().getContextPath());
        session.setAttribute("site","晓晓网上商城");
        return "index";
    }
}
