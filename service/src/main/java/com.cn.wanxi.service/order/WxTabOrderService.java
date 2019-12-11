package com.cn.wanxi.service.order;

import com.cn.wanxi.model.order.WxOrderVO;
import com.cn.wanxi.model.order.WxTabOrder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface WxTabOrderService {

    int insert(WxOrderVO wxOrderVO, String username);

    List<WxTabOrder> selectByIds(String[] ids);

    boolean delete(String orderId,String username);

    boolean deletes(String orderIds,String username);
}