package com.cn.wanxi.service.productdetails;

import com.cn.wanxi.model.cart.WxTabSpu;
import com.cn.wanxi.model.user.User;

import java.util.List;
import java.util.Map;
/**
 * @program: product
 * @description:商品详情
 * @author: wangxuesong
 * @create: 2019-11-20 11:33
 */
public interface ProductDetailsServiceImpl  {
    Map<String,Object> productDetails(int id);

    List<WxTabSpu> search(String conditionpara);
}
