package com.cn.wanxi.service.user;

import com.cn.wanxi.dao.user.WxTabReturnOrderDao;
import com.cn.wanxi.model.user.WxTabReturnOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @author lxq
 * @date 2019年11月21日16:18:01
 */
@Service
public class WxTabReturnOrderServiceImpl implements WxTabReturnOrderService {
    @Autowired
    private WxTabReturnOrderDao wxTabReturnOrderDao;

    @Override
    public boolean add(WxTabReturnOrder wxTabReturnOrder) {
        wxTabReturnOrder.setApplyTime(new Date());
        wxTabReturnOrder.setStatus('0');
        Integer num = wxTabReturnOrderDao.insert(wxTabReturnOrder);
        if(num == 1){
            return true;
        }
        return false;
    }
}