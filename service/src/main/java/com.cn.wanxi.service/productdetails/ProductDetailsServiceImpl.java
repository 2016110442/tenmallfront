package com.cn.wanxi.service.productdetails;

import com.cn.wanxi.model.cart.WxTabSpu;
import com.cn.wanxi.model.user.User;

import java.util.List;
import java.util.Map;

public interface ProductDetailsServiceImpl  {
    Map<String,Object> productDetails(int id);

    List<WxTabSpu> search(String conditionpara);
}
