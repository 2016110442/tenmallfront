package com.cn.wanxi.service.order;

import com.cn.wanxi.dao.order.WxTabOrderMapper;
import com.cn.wanxi.model.order.WxTabOrder;
import org.springframework.beans.factory.annotation.Autowired;

public class WxTabOrderServiceImpl implements WxTabOrderService {

    @Autowired
    private WxTabOrderMapper wxTabOrderMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return wxTabOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WxTabOrder record) {
        return wxTabOrderMapper.insert(record);
    }

    @Override
    public int insertSelective(WxTabOrder record) {
        return wxTabOrderMapper.insertSelective(record);
    }

    @Override
    public WxTabOrder selectByPrimaryKey(String id) {
        return wxTabOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WxTabOrder record) {
        return wxTabOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WxTabOrder record) {
        return wxTabOrderMapper.updateByPrimaryKey(record);
    }
}