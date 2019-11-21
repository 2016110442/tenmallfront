package com.cn.wanxi.dao.user;

import com.cn.wanxi.model.user.WxTabReturnCause;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;


/**
 * @author lxq
 * @date 2019年11月21日15:55:55
 */
public interface WxTabReturnCauseDao {

    @Insert("insert into wx_tab_return_cause(cause,seq,status) values(#{wxTabReturnCause.cause},#{wxTabReturnCause.seq},#{wxTabReturnCause.status})")
    Integer insert(@Param("wxTabReturnCause") WxTabReturnCause wxTabReturnCause);

}
