package com.cn.wanxi.dao.user;

import com.cn.wanxi.model.user.WxTabReturnOrderItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;


/**
 * @author lxq
 * @date 2019年11月21日16:12:55
 */
public interface WxTabReturnOrderItemDao {

    @Insert("insert into wx_tab_return_order_item(category_id,spu_id,sku_id,order_id,order_item_id,return_order_id,title,price,num,money,pay_money,image,weight) " +
            "values(#{wxTabReturnOrderItem.categoryId},#{wxTabReturnOrderItem.spuId},#{wxTabReturnOrderItem.skuId},#{wxTabReturnOrderItem.orderId},#{wxTabReturnOrderItem.orderItemId},#{wxTabReturnOrderItem.returnOrderId},#{wxTabReturnOrderItem.title},#{wxTabReturnOrderItem.price},#{wxTabReturnOrderItem.num},#{wxTabReturnOrderItem.money},#{wxTabReturnOrderItem.payMoney},#{wxTabReturnOrderItem.image},#{wxTabReturnOrderItem.weight})")
    Integer insert(@Param("wxTabReturnOrderItem") WxTabReturnOrderItem wxTabReturnOrderItem);

}
