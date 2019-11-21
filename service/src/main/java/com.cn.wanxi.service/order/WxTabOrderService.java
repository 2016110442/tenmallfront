package com.cn.wanxi.service.order;

import com.cn.wanxi.model.order.WxOrderVO;
import com.cn.wanxi.model.order.WxTabOrder;

import java.util.List;

public interface WxTabOrderService {

    int insert(WxOrderVO wxOrderVO);

    List<WxTabOrder> selectByIds(String[] ids);
}