package com.cn.wanxi.service.order;

import com.cn.wanxi.model.order.WxTabOrderItem;

import java.util.List;

public interface WxTabOrderItemService {

    int insert(WxTabOrderItem record);

    List<WxTabOrderItem> findBySkuIds(String[] skuIds);
}