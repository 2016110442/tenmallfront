package com.cn.wanxi.service.order;

import com.cn.wanxi.dao.order.WxTabOrderItemMapper;
import com.cn.wanxi.model.order.WxTabOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxTabOrderItemServiceImpl implements WxTabOrderItemService {

    @Autowired
    private WxTabOrderItemMapper wxTabOrderItemMapper;

    @Override
    public int insert(WxTabOrderItem record) {
        return wxTabOrderItemMapper.insert(record);
    }

    @Override
    public List<WxTabOrderItem> findBySkuIds(String[] skuIds) {
        return wxTabOrderItemMapper.findBySkuIds(skuIds);
    }
}