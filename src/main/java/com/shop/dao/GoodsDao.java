package com.shop.dao;

import com.shop.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: lingjunhao
 * create at:  19/2/18  下午3:50
 * @description: 商品dao层
 */
@Repository
public interface GoodsDao {
    public List<Goods> getGoodsByPageAndOrder(Map<String, Object> params);

    /**
    	 * 添加商品
    	 * @param goods 要添加的商品实体
    	 * @param
    	 * @return
    	 */
    public void addGoods(Goods goods);

    /**
    * 得到所有商品
    * @param
    * @return 所有的商品实体集合
    */
    public List<Goods> getGoods(Goods goods);

    /**
    * 用于分页查询
    * @param params
    * @return 分页后的商品集合
    */
    public List<Goods> getGoodsByPage(Map<String, Object> params);

    /**
    * 查询商品的数量
    * @param goods
    * @return
    */
    public int getGoodsNum(Goods goods);

    /**
    * 通过商品的id得到商品的信息
    * @param id 商品的id
    * @return 返回整个商品的信息
    */
    public Goods getGoodsById(String id);

    /**
    	 * 实现更新商品的操作
    	 * @param goods 封装的goods参数
    	 * @param
    	 */
    public void updateGoods(Goods goods);

    /**
    	 * 通过id来删除商品
    	 * @param id
    	 */
    public void deleteGoods(String id);

    /**
    	 * 通过分类的id来获取商品
    	 * @param cateId 某个分类的id
     * @param num   需要得到的商品的条数
     * @return 返回一个带有goods的集合
    	 */
    public List<Goods> getGoodsByCateId(@Param("cateId") String cateId,
                                        @Param("num") int num);

    /**
     * 通过对商品的热度进行排序，取前若干项
     * @param num 得到的条数
     * @return 返回一个带有Goods的集合
     */
    public List<Goods> getGoodsByRole(int num);

    /**
    * 通过对商品的推出时间进行排序，取前若干项
    * @param num 得到的条数
    * @return 返回一个带有Goods的集合
    */
    public List<Goods> getGoodsBySellTime(int num);

    /**
    * 通过对商品的推出时间进行排序，取前若干项
    * @param num 得到的条数
    * @return 返回一个带有Goods的集合
    */
    public List<Goods> getGoodsBySellNum(int num);

    /**
    * 通过一个goodsId的数组来获取一个goods的集合
    * @param ids 一个含有goodsid的集合
    * @return 返回含有Goods的集合
    */
    public List<Goods> getGoodsByIds(String[] ids);

    public List<Goods> getGoodsByOrder(Map<String, Object> params);

}
