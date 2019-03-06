package com.shop.service;

import com.shop.entity.Goods;
import com.shop.entity.PageBean;

import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/18  下午5:08
 * @description: 商品Service
 */
public interface GoodsService {
    public PageBean<Goods> getGoodsByPageAndOrder(int page, Goods goods, String order);

    /**
    * 搜索商品
    * @param keyWord
    * @return
    */
    public List<Goods> search(String keyWord);

    /*
    * 简历商品的搜索索引
    * */
    public void createIndex();

    /**
    * 添加商品
    * @param goods
    * @return
    */
    public void addGoods(Goods goods);

    /**
    * 得到所有的商品
    * @param
    * @return
    */
    public List<Goods> getGoods(Goods goods);

    /**
    * 通过参数得到一个含有Goods实体类的PageBean
    * @param page 当前的页数
     * @param goods PageBean包含的实体类
    * @return
    */
    public PageBean<Goods> getGoodsByPage(int page, Goods goods);

    /**
    * 通过商品的id得到商品的信息
    * @param id
    * @return 返回整个商品的信息
    */
    public Goods getGoodsById(String id);

    /**
    	 * 实现更新商品
    	 * @param goods 封装的 Goods参数
    	 * @param
    	 */
    public void updateGoods(Goods goods);

    /**
    	 * 通过id的来删除一个商品
    	 * @param goods
    	 */
    public void deleteGoods(Goods goods);

    /**
    * 通过order的排序条件进行排序
    * @param order 排序的条件
     * @param num 取得条数
     * @param cateId 商品的id
    * @return 一个带有Goods的集合
    */
    public List<Goods> getGoodsByOrder(String order, int num, String cateId);

    /**
    * 通过order的排序条件进行排序

     * @param num 取得条数
    * @return 一个带有Goods集合
    */
    public List<Goods> getGoodsBySellNum(int num);

    /**
     * 通过order的排序条件进行排序

     * @param num 取得条数
     * @return 一个带有Goods的集合
     */
    public List<Goods> getGoodsByRole(int num);

    /**
     * 通过order的排序条件进行排序
     * @param num 取得条数
     * @return 一个带有Goods的集合
     */
    public List<Goods> getGoodsBySellTime(int num);

    /**
     * 通过分类的id来得到商品
     * @param cateId 某个分类的id
     * @return 返回一个带有Goods的集合
     */
    public List<Goods> getGoodsByCateId(String cateId);

    /**
     * 通过一个goodsId的数组来获取一个goods的集合
     * @param ids 一个可变长度的参数的类型
     * @return 返回含有Goods的集合
     */
    public List<Goods> getGoodsByIds(String... ids);

}
