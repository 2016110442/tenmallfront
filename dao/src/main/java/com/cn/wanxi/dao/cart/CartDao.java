package com.cn.wanxi.dao.cart;

import com.cn.wanxi.model.cart.AddCartModel;
import com.cn.wanxi.model.user.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2019/11/20 9:38
 */
@Mapper
public interface CartDao {

    /**
     * 1.2.7.1. 添加购物车接口
     */
    @Insert("insert into wx_tab_cart(sku_id,spu_id,spec,num) values(#{addCartModel.skuId},#{addCartModel.spuId},#{addCartModel.spec},#{addCartModel.num})")
    int addCart(@Param("addCartModel") AddCartModel addCartModel);
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
    @Select("select id,username from user where id=#{id}")
    List findCartList(int page, int size);
    /**
     *  1.2.7.5.获取商品skuid接口
     */
    @Select("select id,username from user where id=#{id}")
    List getSkuid(int spuid, String spec);
    /**
     *  1.2.7.6.查看产品详情接口
     */
    @Select("select id,username from user where id=#{id}")
    List cardDetail(int id);
}
