package com.cn.wanxi.dao.productdetails;

import com.cn.wanxi.model.cart.WxTabSku;
import com.cn.wanxi.model.cart.WxTabSpu;
import com.cn.wanxi.model.productdetails.ProductSearch;
import com.cn.wanxi.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: product
 * @description:商品详情
 * @author: wangxuesong
 * @create: 2019-11-20 11:33
 */
@Mapper
public interface ProductDetailsDao {


    @Select("SELECT id,name,caption,brand_id,category1_id,category2_id,category3_id,\n" +
            "freight_id,image,images,introduction,sale_service,sn,template_id from wx_tab_spu WHERE id=#{id}")
    WxTabSpu productDetailsWxTabSpuList(int id);

    @Select("SELECT id,sn,num,alert_num,price,spec,image,\n" +
            "images,`status`,weight from wx_tab_sku WHERE spu_id=#{id}")
    List<WxTabSku> productDetailsWxTabSkuList(int id);

    List<ProductSearch> search(@Param("conditionpara") String conditionpara);

    List<ProductSearch> searchTwo(Integer categoryId3);

}
