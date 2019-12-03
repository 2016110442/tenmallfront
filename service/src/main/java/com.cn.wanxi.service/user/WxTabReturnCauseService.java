package com.cn.wanxi.service.user;

/**
 * @program: tenmallfront
 * @description:
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
import com.cn.wanxi.model.user.WxTabReturnCause;

import javax.servlet.http.HttpServletRequest;

public interface WxTabReturnCauseService {

    //添加
    boolean add(WxTabReturnCause wxTabReturnCause);

    //查询
    WxTabReturnCause find(WxTabReturnCause wxTabReturnCause);

    //关联添加
    boolean addAssociated(HttpServletRequest request,String orderId, String orderItemid, String evidence, String description, String returnCause, String type);
}
