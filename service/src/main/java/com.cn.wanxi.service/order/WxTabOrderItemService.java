package com.cn.wanxi.service.order;

import com.cn.wanxi.model.order.WxTabOrderItem;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface WxTabOrderItemService {

    int insert(WxTabOrderItem record);

    List<WxTabOrderItem> findBySkuIds(String[] skuIds);

    List<WxTabOrderItem> findByIds(String[] Ids);

    PageInfo<Map<String,Object>> pageByPayStatusAndConsignStatus(HttpServletRequest request, Integer page, Integer size, String payStatus, String consignStatus, String username);

    WxTabOrderItem get(String id);
}