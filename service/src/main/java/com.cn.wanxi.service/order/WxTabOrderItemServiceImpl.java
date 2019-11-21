package com.cn.wanxi.service.order;

import com.cn.wanxi.dao.order.WxTabOrderItemMapper;
import com.cn.wanxi.model.order.WxTabOrderItem;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public PageInfo<Map<String,Object>> pageByPayStatusAndConsignStatus(Integer page, Integer size, String payStatus, String consignStatus) {
        PageHelper.startPage(page,size);
        return new PageInfo<Map<String,Object>>(wxTabOrderItemMapper.findByPayStatusAndConsignStatus(payStatus,consignStatus));
    }
}