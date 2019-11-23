package com.cn.wanxi.service.cart;

import com.cn.wanxi.model.cart.WxTabSpu;

import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
public interface WxTabSpuService {

    //多个id查询
    List<WxTabSpu> findByIds(String[] ids);


}
