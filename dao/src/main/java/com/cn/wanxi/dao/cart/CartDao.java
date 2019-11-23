package com.cn.wanxi.dao.cart;


import com.cn.wanxi.model.cart.WxTabCart;
import com.cn.wanxi.model.cart.WxTabSku;
import com.cn.wanxi.model.cart.WxTabSpu;
import org.apache.ibatis.annotations.*;

import java.util.List;

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
    @Insert("insert into wx_tab_cart(sku_id,spu_id,spec,num) values(#{addCartModel.skuId},#{addCartModel.spuId},#{addCartModel.spec},#{addCartModel.num})")
    int addCart(@Param("addCartModel") WxTabCart wxTabCart);
    /**
     *  1.2.7.2.修改商品数量接口
     */
    @Update("update wx_tab_cart set num=#{num} where id=#{id}")
    int updateNum(@Param("id") int id, @Param("num") String num);
    /**
     *  1.2.7.3.移除购物车接口
     */
    @Delete("delete from wx_tab_cart where id=#{id}")
    int deleteCart(int id);
    /**
     *  1.2.7.4.购物车列表接口
     */
    @Select("SELECT sku_id,spu_id,num FROM wx_tab_cart WHERE username='wangsan' LIMIT #{page},#{size}")
    List<WxTabCart> findCartSpuidSkuid(@Param("page") int page,@Param("size") int size);

    @Select("SELECT name,caption,brand_id,category1_id,category2_id,category3_id,\n" +
            "freight_id,image,images,introduction,para_items,sale_service,sn,spec_items,template_id from wx_tab_spu WHERE id=#{spuId}")
    WxTabSpu findCartSpuTab(Integer spuId);

    @Select("SELECT sn,num,alert_num,price,spec,image,\n" +
            "images,`status`,weight from wx_tab_sku WHERE spu_id=#{spuId}")
    List<WxTabSku> findCartSkuTab(Integer spuId);
    /**
     *  1.2.7.5.获取商品skuid接口
     */
    @Select("select sn,num,alert_num,price,spec,image,images,`status`,weight from wx_tab_sku t1 where t1.spu_id=#{spuid} and t1.spec=#{spec}")
    WxTabSku getSkuid(@Param("spuid") int spuid,@Param("spec")  String spec);
    /**
     *  1.2.7.6.查看产品详情接口
     */
//    @Select("select *  from wx_tab_sku t1,wx_tab_spu t2,wx_tab_cart t3 where t3.spu_id=t2.id and t3.sku_id=t1.id and t3.id=#{id}")
//    WxTabSpu cardDetail(int id);


}
