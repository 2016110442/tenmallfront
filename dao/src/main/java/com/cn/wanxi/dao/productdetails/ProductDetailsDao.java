package com.cn.wanxi.dao.productdetails;

import com.cn.wanxi.model.cart.WxTabSku;
import com.cn.wanxi.model.cart.WxTabSpu;
import com.cn.wanxi.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author
 * @date 2019/11/20 9:38
 */
@Mapper
public interface ProductDetailsDao {


    @Select("SELECT name,caption,brand_id,category1_id,category2_id,category3_id,\n" +
            "freight_id,image,images,introduction,para_items,sale_service,sn,spec_items,template_id from wx_tab_spu WHERE id=#{id}")
    WxTabSpu productDetailsWxTabSpuList(int id);

    @Select("SELECT sn,num,alert_num,price,spec,image,\n" +
            "images,`status`,weight from wx_tab_sku WHERE spu_id=#{id}")
    List<WxTabSku> productDetailsWxTabSkuList(int id);
}
