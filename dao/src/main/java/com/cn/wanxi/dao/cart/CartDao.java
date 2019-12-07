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

    int updateNum(@Param("id") int id, @Param("num") String num,@Param("uaername") String uaername);
    /**
     *  1.2.7.3.移除购物车接口
     */

    int deleteCart(@Param("id")int id,@Param("username")String username);
    /**
     *  1.2.7.4.购物车列表接口
     */

    List<WxTabCart> findCartSpuidSkuid(@Param("userName") String userName);


    Map<String,Object> findCartSpuTab(@Param("spuId") Integer spuId);


    WxTabSku findCartSkuTab(@Param("skuId") Integer skuId);

    List<WxTabSku> findCartSkuTabList(@Param("skuId") Integer skuId);
    /**
     *  1.2.7.5.获取商品skuid接口
     */

    WxTabSku getSkuid(@Param("spuid") int spuid,@Param("spec") String spec);


    WxTabCart findCartTab(@Param("id") int id);



}
