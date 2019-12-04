package com.cn.wanxi.dao.cart;


import com.cn.wanxi.model.cart.WxTabCart;
import com.cn.wanxi.model.cart.WxTabSku;
import com.cn.wanxi.model.cart.WxTabSpu;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @program: cart
 * @description:购物车接口类
 * @author: wangxuesong
 * @create: 2019-11-20 11:33
 */
@Mapper
public interface CartDao {

    /**
     * 1.2.7.1. 添加购物车接口
     */

    int addCart(@Param("wxTabCart") WxTabCart wxTabCart);
    /**
     *  1.2.7.2.修改商品数量接口
     */

    int updateNum(@Param("id") int id, @Param("num") String num);
    /**
     *  1.2.7.3.移除购物车接口
     */

    int deleteCart(int id);
    /**
     *  1.2.7.4.购物车列表接口
     */

    List<WxTabCart> findCartSpuidSkuid(@Param("page") int page,@Param("size") int size,@Param("userName") String userName);


    Map<String,Object> findCartSpuTab(Integer spuId);


    List<WxTabSku> findCartSkuTab(Integer spuId);
    /**
     *  1.2.7.5.获取商品skuid接口
     */

    WxTabSku getSkuid(@Param("spuid") int spuid,@Param("spec")  String spec);


    WxTabCart findCartTab(int id);



}
