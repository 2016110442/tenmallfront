package com.cn.wanxi.dao.order;

import com.cn.wanxi.model.order.WxTabOrder;

public interface WxTabOrderMapper {

    int deleteByPrimaryKey(String id);

    int insert(WxTabOrder record);

    int insertSelective(WxTabOrder record);

    WxTabOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WxTabOrder record);

    int updateByPrimaryKey(WxTabOrder record);
}