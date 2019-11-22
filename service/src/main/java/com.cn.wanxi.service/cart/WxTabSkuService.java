package com.cn.wanxi.service.cart;

import com.cn.wanxi.model.cart.WxTabSku;

import java.util.List;


/**
 * @author lxq
 * @date 2019年11月22日11:21:53
 */
public interface WxTabSkuService {

    //多个id查询
    List<WxTabSku> selectByIds(String[] ids);


}
