package com.cn.wanxi.service.order;

import com.auth0.jwt.JWT;
import com.cn.wanxi.dao.order.WxTabOrderItemMapper;
import com.cn.wanxi.dao.order.WxTabOrderMapper;
import com.cn.wanxi.model.order.WxOrderVO;
import com.cn.wanxi.model.order.WxTabOrder;
import com.cn.wanxi.model.order.WxTabOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WxTabOrderServiceImpl implements WxTabOrderService {

    @Autowired
    private WxTabOrderMapper wxTabOrderMapper;

    @Autowired
    private WxTabOrderItemMapper wxTabOrderItemMapper;

    @Override
    public int insert(WxOrderVO wxOrderVO, String username) {
        WxTabOrder wxTabOrder = new WxTabOrder();
        List<WxTabOrderItem> wxTabOrderItems = wxOrderVO.getOrderItem();
        if (wxTabOrderItems==null){
            System.out.println("1");
            return 0;
        }
        for (WxTabOrderItem w :
                wxTabOrderItems) {
            if (w.getPrice()==null||w.getNum()==null){
                System.out.println("2");
                return 0;
            }
        }
        wxTabOrder.setTotalNum(wxOrderVO.getTotalNum());
        wxTabOrder.setTotalMoney(wxOrderVO.getTotalMoney());
        wxTabOrder.setPreMoney(0);
        wxTabOrder.setPostFee(0);
        wxTabOrder.setPayMoney(wxOrderVO.getTotalMoney());
        wxTabOrder.setPayType(wxOrderVO.getPayType());

        wxTabOrder.setUsername(username);
        wxTabOrder.setReceiverContact(wxOrderVO.getReceiverContact());
        wxTabOrder.setReceiverMobile(wxOrderVO.getReceiverMobile());
        wxTabOrder.setReceiverAddress(wxOrderVO.getReceiverAddress());
        wxTabOrder.setTransactionId(String.valueOf(new Date().getTime()));
        wxTabOrderMapper.insert(wxTabOrder);
        for (WxTabOrderItem w :
                wxTabOrderItems) {
            w.setOrderId(wxTabOrder.getId());
            w.setMoney(w.getPrice()*w.getNum());
            w.setPayMoney(w.getPrice()*w.getNum());
        }
        wxTabOrderItemMapper.insertList(wxTabOrderItems);
        return 1;
    }

    @Override
    public List<WxTabOrder> selectByIds(String[] ids) {
        return wxTabOrderMapper.selectByIds(ids);
    }

    @Override
    public boolean delete(String orderId,String username) {
        int num =wxTabOrderMapper.delete(orderId);
        if(num==1){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deletes(String orderIds,String username) {
        String[] deleteOrderIds =orderIds.split(",");
        for (String orderId:deleteOrderIds) {
            List<WxTabOrderItem> wxTabOrderItems = wxTabOrderItemMapper.findByOrderId(orderId);
            for (WxTabOrderItem wxTabOrderItem:wxTabOrderItems) {
                wxTabOrderItemMapper.delete(wxTabOrderItem.getId());
            }
            if(!delete(orderId,username)){
                return false;
            }
        }
        return true;
    }
}