package com.cn.wanxi.dao.order;

import com.cn.wanxi.model.order.WxTabOrderItem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WxTabOrderItemMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(WxTabOrderItem record);

    int insertSelective(WxTabOrderItem record);

    WxTabOrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxTabOrderItem record);

    int updateByPrimaryKey(WxTabOrderItem record);

    @Select({
            "<script>",
                "select * from wx_tab_order_item where sku_id in ",
                "<foreach collection='skuIds' item='item' open='(' separator=',' close=')'>",
                    "#{item}",
                "</foreach>",
            "</script>"
    })
    List<WxTabOrderItem> findBySkuIds(@Param("skuIds") String[] skuIds);
}