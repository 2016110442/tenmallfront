package com.cn.wanxi.dao.online;

import com.cn.wanxi.model.cart.WxTabSpu;

import java.util.List;

public interface ProductOnlineDao {
    public List<WxTabSpu> getOnlineProducts();
}
