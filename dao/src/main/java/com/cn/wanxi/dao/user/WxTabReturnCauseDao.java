package com.cn.wanxi.dao.user;

import com.cn.wanxi.model.user.WxTabReturnCause;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author lxq
 * @date 2019年11月21日15:55:55
 */
public interface WxTabReturnCauseDao {

    @Insert("insert into wx_tab_return_cause(cause,seq,status) values(#{wxTabReturnCause.cause},#{wxTabReturnCause.seq},#{wxTabReturnCause.status})")
    Integer insert(@Param("wxTabReturnCause") WxTabReturnCause wxTabReturnCause);

    @Select("select * from wx_tab_return_cause where cause=#{wxTabReturnCause.cause} and status=#{wxTabReturnCause.status}")
    List<WxTabReturnCause> find(@Param("wxTabReturnCause") WxTabReturnCause wxTabReturnCause);
}
