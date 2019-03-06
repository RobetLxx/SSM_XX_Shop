package com.shop.service;

import com.shop.entity.PageBean;
import com.shop.entity.Visit;

import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/18  下午3:24
 * @description: 访客service
 */
public interface VisitService {
    public List<Visit> getAllVisit();
    public PageBean<Visit> getVisitsByPage(Integer page);
}
