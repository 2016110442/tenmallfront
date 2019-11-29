package com.cn.wanxi.dao.user;

import com.cn.wanxi.model.user.WxTabReturnCause;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @program: tenmallfront
 * @description: 退货退款原因dao层
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
public interface WxTabReturnCauseDao {

//    @Insert("insert into wx_tab_return_cause(cause,seq,status) values(#{wxTabReturnCause.cause},#{wxTabReturnCause.seq},#{wxTabReturnCause.status})")
    Integer insert(@Param("wxTabReturnCause") WxTabReturnCause wxTabReturnCause);

//    @Select("select * from wx_tab_return_cause where cause=#{wxTabReturnCause.cause} and status=#{wxTabReturnCause.status}")
    List<WxTabReturnCause> find(@Param("wxTabReturnCause") WxTabReturnCause wxTabReturnCause);
}
