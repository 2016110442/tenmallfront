package com.cn.wanxi.service.cart;

import com.cn.wanxi.model.cart.WxTabSku;

import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
public interface WxTabSkuService {

    //多个id查询
    List<WxTabSku> selectByIds(String[] ids);


}
