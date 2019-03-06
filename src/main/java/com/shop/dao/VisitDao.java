package com.shop.dao;

import com.shop.entity.Visit;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: lingjunhao
 * create at:  19/2/18  下午3:10
 * @description: 访客dao层
 */

@Repository
public interface VisitDao {
    public List<Visit> getAllVisit();

    public List<Visit> getVisitByPage(Map<String, Object> params);

    public int getVisitNum();


}
