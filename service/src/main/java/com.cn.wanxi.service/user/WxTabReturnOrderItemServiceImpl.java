package com.cn.wanxi.service.user;

import com.cn.wanxi.dao.user.WxTabReturnOrderItemDao;
import com.cn.wanxi.model.user.WxTabReturnOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: tenmallfront
 * @description:
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
@Service
public class WxTabReturnOrderItemServiceImpl implements WxTabReturnOrderItemService {
    @Autowired
    private WxTabReturnOrderItemDao wxTabReturnOrderItemDao;

    @Override
    public boolean add(WxTabReturnOrderItem wxTabReturnOrderItem) {
        Integer num = wxTabReturnOrderItemDao.insert(wxTabReturnOrderItem);
        if(num == 1){
            return true;
        }
        return false;
    }
}