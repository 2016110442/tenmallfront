package com.cn.wanxi.dao.order;

import com.cn.wanxi.model.order.WxTabOrderItem;

public interface WxTabOrderItemMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(WxTabOrderItem record);

    int insertSelective(WxTabOrderItem record);

    WxTabOrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxTabOrderItem record);

    int updateByPrimaryKey(WxTabOrderItem record);
}