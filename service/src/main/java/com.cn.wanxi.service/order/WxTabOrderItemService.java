package com.cn.wanxi.service.order;

import com.cn.wanxi.model.order.WxTabOrderItem;

import java.util.List;

public interface WxTabOrderItemService {

    int deleteByPrimaryKey(Integer id);

    int insert(WxTabOrderItem record);

    int insertSelective(WxTabOrderItem record);

    WxTabOrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxTabOrderItem record);

    int updateByPrimaryKey(WxTabOrderItem record);

    List<WxTabOrderItem> findBySkuIds(String[] skuIds);
}