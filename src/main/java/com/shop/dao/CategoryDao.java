package com.shop.dao;

import com.shop.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao {
    /**
    	 * 填一个Category实体类的对象
    	 * @param category
    	 * @param
    	 * @return
    	 */
    public  void addCategory(Category category);

    /**
    * 得到所有的商品分类
    * @param 
    * @return 返回所有商品分类对应的集合
    */
    public List<Category> getCategories();
    
    /**
    	 * 通过名字来获取当前的分类实体
    	 * @param name
    	 */
    public int getCategoryByName(String name);

    /**
    * 通过分类的id删除分类
    * @param id
    * @return
    */
    public void deleteCategory(String id);

    /**
    * 通过id来修改当前的商品分类的属性
    * @param id
    * @param name 商品的名称
    */
    public void updateCategory(@Param("id") String id,
                               @Param("name") String name);

    /**
    * 通过id来修改当前的商品分类的属性
    * @param id
    * @param goodsNum 商品的数量
    */
    public void updateGoodsNum(@Param("id") String id,
                               @Param("goodsNum") int goodsNum);

    /**
    * 通过类别的id来得到当前类别信息
    * @param id 某一个类别的id
    * @return 返回当前类别的实体类
    */
    public Category getCategoryById(String id);
}
