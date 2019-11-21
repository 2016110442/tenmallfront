package com.cn.wanxi.dao.order;

import com.cn.wanxi.model.order.WxTabOrderItem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface WxTabOrderItemMapper {

    int insert(WxTabOrderItem record);

//     <insert id="addEmpsBatch">
//    INSERT INTO emp(ename,gender,email,did)
//    VALUES
//            <foreach collection="emps" item="emp" separator=",">
//            (#{emp.eName},#{emp.gender},#{emp.email},#{emp.dept.id})
//      </foreach>
//     </insert>
    @Select({
            "<script>",
            "insert into wx_tab_order_item(category_id1,category_id2,category_id3,spu_id,sku_id,order_id,name,price,num,money,pay_money,image,post_fee) values",
            "<foreach collection='lists' item='item' separator=','>",
            "(#{item.categoryId1},#{item.categoryId2},#{item.categoryId3},#{item.spuId},#{item.skuId},#{item.orderId},#{item.name},#{item.price},#{item.num},#{item.money},#{item.payMoney},#{item.image},#{item.postFee})",
            "</foreach>",
            "</script>"
    })
    Integer insertList(@Param("lists") List<WxTabOrderItem> lists);

    @Select({
            "<script>",
                "select * from wx_tab_order_item where sku_id in ",
                "<foreach collection='skuIds' item='item' open='(' separator=',' close=')'>",
                    "#{item}",
                "</foreach>",
            "</script>"
    })
    List<WxTabOrderItem> findBySkuIds(@Param("skuIds") String[] skuIds);

    List<Map<String,Object>> findByPayStatusAndConsignStatus(@Param("payStatus") String payStatus,@Param("consignStatus") String consignStatus);
}