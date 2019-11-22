package com.cn.wanxi.service.cart;

import com.cn.wanxi.model.cart.WxTabSpu;

import java.util.List;


/**
 * @author lxq
 * @date 2019年11月22日11:21:53
 */
public interface WxTabSpuService {

    //多个id查询
    List<WxTabSpu> findByIds(String[] ids);


}
