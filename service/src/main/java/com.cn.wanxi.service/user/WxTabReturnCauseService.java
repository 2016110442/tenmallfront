package com.cn.wanxi.service.user;

/**
 * @author lxq
 * @date 2019年11月21日15:55:48
 */
import com.cn.wanxi.model.user.WxTabReturnCause;

public interface WxTabReturnCauseService {

    //添加
    boolean add(WxTabReturnCause wxTabReturnCause);

    //关联添加
    boolean addAssociated(String orderId, String orderItemid, String evidence, String description, Integer returnCause, String type);
}
