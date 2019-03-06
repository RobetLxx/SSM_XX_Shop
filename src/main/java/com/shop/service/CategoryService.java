package com.shop.service;

import com.shop.entity.Category;

import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/18  下午5:53
 * @description: 商品分类service
 */
public interface CategoryService {
    /**
    * 添加一个商品分类
    * @param category 分类的实体类对象
    * @return
    */
    public void addCategory(Category category);

    /**
    * 得到当前所有的分类
    * @param
    * @return 返回所有分类的集合
    */
    public List<Category> getCategiries();

    /**
    * 通过名字得到当前的分类实体
    * @param name 当前的名字
    * @return
    */
    public boolean getCategoryByName(String name);

    /**
    * 通过分类的id删除分类
    * @param id 分类的id
    * @return
    */
    public void deleteCategory(String id);

    /**
    	 * 实现更新当前商品分类
    	 * @param id 当前商品的商品id
    	 * @param
    	 */
    public void updateCategory(String id, String name);

    /**
    * 主要为首页来得到Categories
    *
    * @return 带有Categories的集合List
    */
    public List<Category> getCateoriesForIndex();

    /**
    * 通过类别的id来得到当前类别信息
    * @param id 某一个类别的id
    * @return 返回当前类别的实体类
    */
    public Category getCategoryById(String id);


}
