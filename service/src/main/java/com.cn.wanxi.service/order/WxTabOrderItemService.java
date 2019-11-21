package com.cn.wanxi.service.order;

import com.cn.wanxi.model.order.WxTabOrderItem;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface WxTabOrderItemService {

    int insert(WxTabOrderItem record);

    List<WxTabOrderItem> findBySkuIds(String[] skuIds);

    PageInfo<Map<String,Object>> pageByPayStatusAndConsignStatus(Integer page, Integer size, String payStatus, String consignStatus);

    WxTabOrderItem get(String id);
}