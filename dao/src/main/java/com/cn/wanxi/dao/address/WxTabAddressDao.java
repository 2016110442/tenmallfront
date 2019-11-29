package com.cn.wanxi.dao.address;

import org.apache.ibatis.annotations.*;
import com.cn.wanxi.model.address.WxTabAddress;

import java.util.List;


/**
 * @program: tenmallfront
 * @description: 地址dao层
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
public interface WxTabAddressDao {

//    @Select("select * from wx_tab_address where id=#{id}")
    WxTabAddress get(@Param("id") String id);

//    @Select("select * from wx_tab_address")
    List<WxTabAddress> find(@Param("wxTabAddress") WxTabAddress wxTabAddress);

//    @Insert("insert into wx_tab_address(receiver_address,receiver_name,receiver_phone,username,is_default) value(#{wxTabAddress.receiverAddress},#{wxTabAddress.receiverName},#{wxTabAddress.receiverPhone},#{wxTabAddress.username},#{wxTabAddress.isDefault})")
    Integer insert(@Param("wxTabAddress") WxTabAddress wxTabAddress);

//    @Update("update wx_tab_address set receiver_address=#{wxTabAddress.receiverAddress},receiver_name=#{wxTabAddress.receiverName},receiver_phone=#{wxTabAddress.receiverPhone},username=#{wxTabAddress.username},is_default=#{wxTabAddress.isDefault} where id=#{wxTabAddress.id}")
    Integer update(@Param("wxTabAddress") WxTabAddress wxTabAddress);

//    @Delete("delete from wx_tab_address where id=#{id}")
    Integer delete(@Param("id") Integer id);
}
