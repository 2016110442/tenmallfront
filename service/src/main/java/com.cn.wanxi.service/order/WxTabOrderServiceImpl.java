package com.cn.wanxi.service.order;

import com.cn.wanxi.dao.order.WxTabOrderItemMapper;
import com.cn.wanxi.dao.order.WxTabOrderMapper;
import com.cn.wanxi.model.order.WxOrderVO;
import com.cn.wanxi.model.order.WxTabOrder;
import com.cn.wanxi.model.order.WxTabOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WxTabOrderServiceImpl implements WxTabOrderService {

    @Autowired
    private WxTabOrderMapper wxTabOrderMapper;

    @Autowired
    private WxTabOrderItemMapper wxTabOrderItemMapper;

    @Override
    public int insert(WxOrderVO wxOrderVO) {
        WxTabOrder wxTabOrder = new WxTabOrder();
        List<WxTabOrderItem> wxTabOrderItems = wxOrderVO.getOrderItem();
        wxTabOrder.setTotalNum(wxOrderVO.getTotalNum());
        wxTabOrder.setTotalMoney(wxOrderVO.getTotalMoney());
        wxTabOrder.setPreMoney(wxOrderVO.getPreMoney());
        wxTabOrder.setPostFee(wxOrderVO.getPostFee());
        wxTabOrder.setPayMoney(wxOrderVO.getPayMoney());
        wxTabOrder.setPayType(wxOrderVO.getPayType());
        wxTabOrder.setUsername(wxOrderVO.getUsername());
        wxTabOrder.setReceiverContact(wxOrderVO.getReceiverContact());
        wxTabOrder.setReceiverMobile(wxOrderVO.getReceiverMobile());
        wxTabOrder.setReceiverAddress(wxOrderVO.getReceiverAddress());
        wxTabOrder.setTransactionId("1");
        wxTabOrderMapper.insert(wxTabOrder);
        for (WxTabOrderItem w :
                wxTabOrderItems) {
            w.setOrderId(wxTabOrder.getId());
        }
        wxTabOrderItemMapper.insertList(wxTabOrderItems);
        return 1;
    }

    @Override
    public List<WxTabOrder> selectByIds(String[] ids) {
        return wxTabOrderMapper.selectByIds(ids);
    }
}