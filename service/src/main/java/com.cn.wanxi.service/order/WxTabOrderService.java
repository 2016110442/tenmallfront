package com.cn.wanxi.service.order;

import com.cn.wanxi.model.order.WxTabOrder;

public interface WxTabOrderService {

    int deleteByPrimaryKey(String id);

    int insert(WxTabOrder record);

    int insertSelective(WxTabOrder record);

    WxTabOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WxTabOrder record);

    int updateByPrimaryKey(WxTabOrder record);
}