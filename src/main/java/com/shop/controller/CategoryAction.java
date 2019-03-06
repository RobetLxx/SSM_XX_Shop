package com.shop.controller;

import com.shop.entity.Category;
import com.shop.service.CategoryService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/19  下午3:03
 * @description: 商品分类controller
 */
@Controller
@RequestMapping("/category")
public class CategoryAction {
    @Autowired
    private CategoryService categoryService;
    
    /**
    * 增加商品分类
    * @param categoryName
    * @return
    */
    @RequestMapping("/add")
    public String add(String categoryName){
        Category category=new Category();
        category.setName(categoryName);
        categoryService.addCategory(category);
        return "redirect:/category/list";
    }

    /**
    * 显示所有的商品分类
    * @param model
    * @return
    */
    @RequestMapping("/list")
    public String list(Model model){
        List<Category> categories=categoryService.getCategiries();
        model.addAttribute("categories",categories);
        return "/admin/category_list";
    }

    /**
    * 用来判断当前商品是否存在
    * @param category
    * @return
    */
    @RequestMapping("/isexist")
    public void isexist(Category category){
        boolean isexist=categoryService.getCategoryByName(category.getName());
        PrintWriter write=null;
        try {
            write = ServletActionContext.getResponse().getWriter();
            write.print(!isexist);
            write.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            write.close();
        }
    }

    /**
    	 * 通过分类id的来删除当前用户点击的商品分类
    	 * @param categoryId
    	 */
    @RequestMapping("/delete")
    public String delete(String categoryId){
        System.out.println("Now Delete CateGory where categoryId is "+categoryId);
        categoryService.deleteCategory(categoryId);
        return "redirect:/category/list";
    }

    /**
    * 修改商品信息
    * @param categoryId
     * @param category
    * @return
    */
    @RequestMapping("/update")
    public void update(String categoryId,Category category){
        boolean isexist=(categoryService.getCategoryById(categoryId)==null);
        PrintWriter write = null;
        try {
            write = ServletActionContext.getResponse().getWriter();
            if (!isexist){
                categoryService.updateCategory(category.getId(),category.getName());
                write.print(!isexist);
                write.flush();
            }else {
                write.print(!isexist);
                write.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            write.close();
        }
    }

    /**
    * 接受表单的数据，将页面刷新一下
    * @param
    * @return
    */
    @RequestMapping("/refresh")
    public String refresh(){
        return "redirect:/category/list";
    }
}
