package com.shop.service.impl;

import com.shop.dao.CategoryDao;
import com.shop.dao.GoodsDao;
import com.shop.entity.Category;
import com.shop.service.CategoryService;
import com.shop.util.ShopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/18  下午7:38
 * @description: 商品分类serviceimpl
 */

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao=null;
    @Autowired
    private GoodsDao goodsDao=null;

    @Override
    public void addCategory(Category category) {
        category.setId(ShopUtil.getId());
        categoryDao.addCategory(category);
    }

    @Override
    public List<Category> getCategiries() {
        return categoryDao.getCategories();
    }

    @Override
    public boolean getCategoryByName(String name) {
        int num = categoryDao.getCategoryByName(name);
        return num!=0;
    }

    @Override
    public void deleteCategory(String id) {
        categoryDao.deleteCategory(id);
    }

    @Override
    public void updateCategory(String id, String name) {
        categoryDao.updateCategory(id,name);
    }

    @Override
    public List<Category> getCateoriesForIndex() {
        List<Category> categories=categoryDao.getCategories();
        for (Category category:categories){
            System.out.println("category: " +category.getId());
            category.setGoodses(goodsDao.getGoodsByCateId(category.getId(),4));
        }
        return categories;
    }

    @Override
    public Category getCategoryById(String id) {
        return categoryDao.getCategoryById(id);
    }

    //getting and setting
    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
}
