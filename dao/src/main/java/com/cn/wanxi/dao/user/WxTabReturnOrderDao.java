package com.cn.wanxi.dao.user;

import com.cn.wanxi.model.user.WxTabReturnOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;


/**
 * @program: tenmallfront
 * @description: 退货退款申请dao层
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
public interface WxTabReturnOrderDao {

//    @Insert("insert into " +
//            "wx_tab_return_order(order_id,apply_time,user_id,user_account,linkman,linkman_mobile,type,return_money,is_return_freight,status,dispose_time,return_cause,evidence,description,remark,admin_id) " +
//            "values" +
//            "(#{wxTabReturnOrder.orderId},#{wxTabReturnOrder.applyTime},#{wxTabReturnOrder.userId},#{wxTabReturnOrder.userAccount},#{wxTabReturnOrder.linkman},#{wxTabReturnOrder.linkmanMobile},#{wxTabReturnOrder.type},#{wxTabReturnOrder.returnMoney},#{wxTabReturnOrder.isReturnFreight},#{wxTabReturnOrder.status},#{wxTabReturnOrder.disposeTime},#{wxTabReturnOrder.returnCause},#{wxTabReturnOrder.evidence},#{wxTabReturnOrder.description},#{wxTabReturnOrder.remark},#{wxTabReturnOrder.adminId})")
    Integer insert(@Param("wxTabReturnOrder") WxTabReturnOrder wxTabReturnOrder);

}
