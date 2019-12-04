package com.cn.wanxi.service.cart;

import com.cn.wanxi.model.cart.WxTabCart;
import com.cn.wanxi.model.cart.WxTabSku;

import java.util.List;
import java.util.Map;
/**
 * @program: cart
 * @description:购物车接口类
 * @author: wangxuesong
 * @create: 2019-11-20 11:33
 */
public interface CartServiceImpl {
    /**
     *  添加购物车接口
     * @param
     * @return
     */
    Map<String, Object> addCart(WxTabCart wxTabCart);
    /**
     *  1.2.7.2.修改商品数量接口
     * @param
     * @return
     */
    Map<String, Object> updateNum(int id,String num);
    /**
     *  1.2.7.3.移除购物车接口
     * @param
     * @return
     */
    Map<String, Object> deleteCart(int id);
    /**
     *  1.2.7.4.购物车列表接口
     * @param
     * @return
     */
    List<Map<String,Object>> findCartList(int page, int size,String username);
    /**
     *  1.2.7.5.获取商品skuid接口
     * @param
     * @return
     */
    WxTabSku getSkuid(int spuid, String spec);
    /**
     *  1.2.7.6.查看产品详情接口
     * @param
     * @return
     */
    Map<String,Object> cardDetail(int id);
}
