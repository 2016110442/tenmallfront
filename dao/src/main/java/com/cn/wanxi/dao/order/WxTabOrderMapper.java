package com.cn.wanxi.dao.order;

import com.cn.wanxi.model.order.WxTabOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WxTabOrderMapper {

    @Insert("insert into wx_tab_order(total_num,total_money,pre_money,post_fee,pay_money,pay_type,username,receiver_contact,receiver_mobile,receiver_address,transaction_id) " +
            "value(#{totalNum},#{totalMoney},#{preMoney},#{postFee},#{payMoney},#{payType},#{username},#{receiverContact},#{receiverMobile},#{receiverAddress},#{transactionId})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(WxTabOrder record);

//    @Select({
//            "<script>",
//            "select * from wx_tab_order where id in ",
//            "<foreach collection='ids' item='item' open='(' separator=',' close=')'>",
//            "#{item}",
//            "</foreach>",
//            "</script>"
//    })
    List<WxTabOrder> selectByIds(@Param("ids") String[] ids);
}